
from fastapi import FastAPI, Depends, HTTPException, Request
from fastapi.middleware.cors import CORSMiddleware
from fastapi.staticfiles import StaticFiles
from sqlalchemy.orm import Session
import models, schemas
from database import Base, engine, get_db

from fastapi import UploadFile, File, Form
import shutil
import os
# from utils import hash_password  # import the helper
from utils import hash_password, verify_password  # import both helpers

from passlib.context import CryptContext

from datetime import datetime, timedelta
import jwt

from fastapi import FastAPI

# MAil And SMS Notification
from utils_notifications import send_email, send_sms

from dotenv import load_dotenv
load_dotenv()


# Create all tables
Base.metadata.create_all(bind=engine)

app = FastAPI(title="Online Herbal Store API")

# ✅ Serve static image files from backend/static/images

app.mount("/images", StaticFiles(directory="static/images"), name="images")
# app.mount("/images", StaticFiles(directory="static/images"), name="images")

# (Optional) If you also want /static for CSS, JS, etc.
# app.mount("/static", StaticFiles(directory="static"), name="static")

# ✅ Allow frontend (React Vite default port)
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],
    allow_methods=["*"],
    allow_headers=["*"]
)




# JWT secret key
SECRET_KEY = "supersecretkey"
ALGORITHM = "HS256"

# ------------------ PASSWORD HELPERS ------------------

def create_access_token(data: dict):
    expire = datetime.utcnow() + timedelta(hours=2)
    data.update({"exp": expire})
    return jwt.encode(data, SECRET_KEY, algorithm=ALGORITHM)

# ---------------- Products ----------------
# @app.post("/products/", response_model=schemas.Product)
# def create_product(product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     """
#     Create a new product. 
#     Example: image_url should be only the filename, like 'coconut-oil.jpg'
#     """
#     db_product = models.Product(**product.dict())
#     db.add(db_product)
#     db.commit()
#     db.refresh(db_product)
#     return db_product


@app.post("/products/upload", response_model=schemas.Product)
def upload_product(
    name: str = Form(...),
    description: str = Form(...),
    price: float = Form(...),
    image: UploadFile = File(...),
    db: Session = Depends(get_db)
):
    # Save Image
    image_filename = image.filename
    image_path = f"static/images/{image_filename}"

    with open(image_path, "wb") as buffer:
        shutil.copyfileobj(image.file, buffer)

    # Save Product Info
    db_product = models.Product(
        name=name,
        description=description,
        price=price,
        image_url=image_filename  # only store filename
    )

    db.add(db_product)
    db.commit()
    db.refresh(db_product)

    return db_product


@app.get("/products/", response_model=list[schemas.Product])
def get_products(request: Request, db: Session = Depends(get_db)):
    """
    Fetch all products and attach correct backend image URL.
    Example: http://127.0.0.1:8000/images/almond-oil.jpg
    """
    products = db.query(models.Product).all()

    for product in products:
        if product.image_url:
            # Extract filename (last part only)
            filename = product.image_url.split("/")[-1]
            # Generate correct URL served by FastAPI
            product.image_url = f"{request.base_url}images/{filename}"

    return products



@app.get("/products/{product_id}", response_model=schemas.Product)
def get_product(product_id: int, db: Session = Depends(get_db)):
    product = db.query(models.Product).filter(models.Product.id == product_id).first()
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    return product


# @app.put("/products/{product_id}", response_model=schemas.Product)
# def update_product(product_id: int, product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not db_product:
#         raise HTTPException(status_code=404, detail="Product not found")
    
#     db_product.name = product.name
#     db_product.description = product.description
#     db_product.price = product.price
#     db_product.image_url = product.image_url  # store only filename
    
#     db.commit()
#     db.refresh(db_product)
#     return db_product



@app.put("/products/{product_id}", response_model=schemas.Product)
def update_product(
    product_id: int,
    request: Request,
    name: str = Form(...),
    description: str = Form(...),
    price: float = Form(...),
    image_url: str = Form(None),           # Existing filename if no new image
    image: UploadFile = File(None),        # Optional new file
    db: Session = Depends(get_db)
):
    db_product = db.query(models.Product).filter(models.Product.id == product_id).first()
    if not db_product:
        raise HTTPException(status_code=404, detail="Product not found")

    # 1️⃣ Handle new image upload
    if image:
        filename = image.filename
        image_path = f"static/images/{filename}"
        with open(image_path, "wb") as buffer:
            shutil.copyfileobj(image.file, buffer)
        db_product.image_url = filename
    elif image_url:
        # Keep existing filename
        db_product.image_url = image_url

    # 2️⃣ Update other fields
    db_product.name = name
    db_product.description = description
    db_product.price = price

    db.commit()
    db.refresh(db_product)

    # 3️⃣ Return product with full image URL
    if db_product.image_url:
        filename = db_product.image_url.split("/")[-1]
        db_product.image_url = f"{request.base_url}images/{filename}"

    return db_product


# ==================================================

@app.delete("/products/{product_id}")
def delete_product(product_id: int, db: Session = Depends(get_db)):
    product = db.query(models.Product).filter(models.Product.id == product_id).first()
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    db.delete(product)
    db.commit()
    return {"message": "Product deleted"}


# ---------------- Users ----------------

# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     db_user = models.User(**user.dict())
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user



# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     # hash the password before saving
#     hashed_pw = hash_password(user.password)
#     db_user = models.User(
#         username=user.username,
#         email=user.email,
#         password=hashed_pw,
#          # 🆕 NEW FIELDS
#         address=user.address,
#         contact_number=user.contact_number

#     )
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user


@app.post("/users/", response_model=schemas.User)
def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):

    # ✅ Validate contact number (must be exactly 10 digits and numeric)
    if not user.contact_number.isdigit() or len(user.contact_number) != 10:
        raise HTTPException(
            status_code=400,
            detail="Contact number must be exactly 10 digits."
        )

    # hash the password before saving
    hashed_pw = hash_password(user.password)

    db_user = models.User(
        username=user.username,
        email=user.email,
        password=hashed_pw,

        # 🆕 NEW FIELDS
        address=user.address,
        contact_number=user.contact_number
    )

    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    
    # ----------------- SEND NOTIFICATIONS -----------------

    email_msg = f"""
Hello {user.username},

🎉 Congratulations!  
You have successfully registered on the Online Herbal Store.

Thank you for joining us!
"""

    sms_msg = "🎉 Welcome to Online Herbal Store! Your registration is successful."

    send_email(user.email, "Registration Successful ✔️", email_msg)
    send_sms(user.contact_number, sms_msg)

    # ------------------------------------------------------

    

    return db_user


@app.get("/users/", response_model=list[schemas.User])
def get_users(db: Session = Depends(get_db)):
    return db.query(models.User).all()


# ------------------ LOGIN USER ------------------

# @app.post("/login")
# def login_user(login_data: schemas.LoginRequest, db: Session = Depends(get_db)):
#     # Find user by email
#     db_user = db.query(models.User).filter(models.User.email == login_data.email).first()
#     if not db_user:
#         raise HTTPException(status_code=400, detail="Invalid email or password")

#     # Verify password
#     if not verify_password(login_data.password, db_user.password):
#         raise HTTPException(status_code=400, detail="Invalid email or password")

#     # Create token
#     token = create_access_token({"sub": db_user.email})

#     return {
#         "message": "Login successful",
#         "access_token": token,
#         "user": {
#             "id": db_user.id,
#             "username": db_user.username,
#             "email": db_user.email
#         }
#     }


@app.post("/login/")
def login_user(login_data: schemas.UserLogin, db: Session = Depends(get_db)):
    user = db.query(models.User).filter(models.User.email == login_data.email).first()
    if not user or not verify_password(login_data.password, user.password):
        raise HTTPException(status_code=400, detail="Invalid email or password")
    return {"message": "Login successful", "user_id": user.id}


# ---------------- Orders ----------------
@app.post("/orders/", response_model=schemas.Order)
def create_order(order: schemas.OrderCreate, db: Session = Depends(get_db)):
    db_order = models.Order(user_id=order.user_id, total_price=order.total_price)
    db.add(db_order)
    db.commit()
    db.refresh(db_order)

    for item in order.items:
        db_item = models.OrderItem(
            order_id=db_order.id,
            product_id=item.product_id,
            quantity=item.quantity,
            price=item.price
        )
        db.add(db_item)
    db.commit()


     # Fetch user details for notification
    user = db.query(models.User).filter(models.User.id == order.user_id).first()

    # ---------------- NOTIFICATION ----------------
    email_msg = f"""
Hello {user.username},

🛒 Your order has been successfully placed!
Order ID: {db_order.id}
Total Amount: ₹{order.total_price}

We will notify you once it is shipped.

Thank you for shopping with Online Herbal Store!
"""

    sms_msg = f"🛒 Order Confirmed! Your Order ID {db_order.id} is placed. Total ₹{order.total_price}."

    send_email(user.email, "Order Confirmed ✔️", email_msg)
    send_sms(user.contact_number, sms_msg)
    # ------------------------------------------------
    return db_order


# @app.get("/orders/", response_model=list[schemas.Order])
# def get_orders(db: Session = Depends(get_db)):
#     return db.query(models.Order).all()

@app.get("/orders/", response_model=list[schemas.Order])
def get_orders(db: Session = Depends(get_db)):
    results = (
        db.query(
            models.Order.id,
            models.Order.user_id,
            models.Order.total_price,
            models.Order.order_date,
            models.User.username,
            models.User.email
        )
        .join(models.User, models.Order.user_id == models.User.id)
        .all()
    )

    return [
        {
            "id": r.id,
            "user_id": r.user_id,
            "total_price": r.total_price,
            "order_date": r.order_date,
            "username": r.username,
            "email": r.email,
            "items": []  # Optional: can fetch order items if needed
        }
        for r in results
    ]


# admin Login

@app.post("/admin/login")
def admin_login(admin: schemas.AdminLogin, db: Session = Depends(get_db)):
    db_admin = db.query(models.Admin).filter(models.Admin.email == admin.email).first()
    if not db_admin or db_admin.password != admin.password:
        raise HTTPException(status_code=401, detail="Invalid email or password")
    return {"message": "Login successful", "admin_name": db_admin.admin_name}