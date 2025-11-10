# from fastapi import FastAPI, Depends, HTTPException
# from fastapi.middleware.cors import CORSMiddleware
# from sqlalchemy.orm import Session
# import models, schemas
# from database import Base, engine, get_db

# # Create all tables
# Base.metadata.create_all(bind=engine)

# app = FastAPI(title="Online Herbal Store API")

# # Allow frontend
# app.add_middleware(
#     CORSMiddleware,
#     allow_origins=["http://localhost:5173"],  # React dev server
#     allow_methods=["*"],
#     allow_headers=["*"]
# )

# # ---------------- Products ----------------
# @app.post("/products/", response_model=schemas.Product)
# def create_product(product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = models.Product(**product.dict())
#     db.add(db_product)
#     db.commit()
#     db.refresh(db_product)
#     return db_product

# @app.get("/products/", response_model=list[schemas.Product])
# def get_products(db: Session = Depends(get_db)):
#     return db.query(models.Product).all()

# @app.get("/products/{product_id}", response_model=schemas.Product)
# def get_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     return product

# @app.delete("/products/{product_id}")
# def delete_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     db.delete(product)
#     db.commit()
#     return {"message": "Product deleted"}

# # ---------------- Users ----------------
# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     db_user = models.User(**user.dict())
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user

# @app.get("/users/", response_model=list[schemas.User])
# def get_users(db: Session = Depends(get_db)):
#     return db.query(models.User).all()

# # ---------------- Orders ----------------
# @app.post("/orders/", response_model=schemas.Order)
# def create_order(order: schemas.OrderCreate, db: Session = Depends(get_db)):
#     db_order = models.Order(user_id=order.user_id, total_price=order.total_price)
#     db.add(db_order)
#     db.commit()
#     db.refresh(db_order)

#     # Add order items
#     for item in order.items:
#         db_item = models.OrderItem(
#             order_id=db_order.id,
#             product_id=item.product_id,
#             quantity=item.quantity,
#             price=item.price
#         )
#         db.add(db_item)
#     db.commit()
#     return db_order

# @app.get("/orders/", response_model=list[schemas.Order])
# def get_orders(db: Session = Depends(get_db)):
#     return db.query(models.Order).all()
#     from fastapi import FastAPI, Depends, HTTPException
# from fastapi.middleware.cors import CORSMiddleware
# from sqlalchemy.orm import Session
# import models, schemas
# from database import Base, engine, get_db

# # Create all tables
# Base.metadata.create_all(bind=engine)

# app = FastAPI(title="Online Herbal Store API")

# # Allow frontend
# app.add_middleware(
#     CORSMiddleware,
#     allow_origins=["http://localhost:5173"],  # React dev server
#     allow_methods=["*"],
#     allow_headers=["*"]
# )

# # ---------------- Products ----------------
# @app.post("/products/", response_model=schemas.Product)
# def create_product(product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = models.Product(**product.dict())
#     db.add(db_product)
#     db.commit()
#     db.refresh(db_product)
#     return db_product

# @app.get("/products/", response_model=list[schemas.Product])
# def get_products(db: Session = Depends(get_db)):
#     return db.query(models.Product).all()

# @app.get("/products/{product_id}", response_model=schemas.Product)
# def get_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     return product

# @app.delete("/products/{product_id}")
# def delete_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     db.delete(product)
#     db.commit()
#     return {"message": "Product deleted"}

# # ---------------- Users ----------------
# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     db_user = models.User(**user.dict())
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user

# @app.get("/users/", response_model=list[schemas.User])
# def get_users(db: Session = Depends(get_db)):
#     return db.query(models.User).all()

# # ---------------- Orders ----------------
# @app.post("/orders/", response_model=schemas.Order)
# def create_order(order: schemas.OrderCreate, db: Session = Depends(get_db)):
#     db_order = models.Order(user_id=order.user_id, total_price=order.total_price)
#     db.add(db_order)
#     db.commit()
#     db.refresh(db_order)

#     # Add order items
#     for item in order.items:
#         db_item = models.OrderItem(
#             order_id=db_order.id,
#             product_id=item.product_id,
#             quantity=item.quantity,
#             price=item.price
#         )
#         db.add(db_item)
#     db.commit()
#     return db_order


#     @app.put("/products/{product_id}", response_model=schemas.Product, tags=["Products"])
# def update_product(product_id: int, product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not db_product:
#         raise HTTPException(status_code=404, detail="Product not found")
    
#     db_product.name = product.name
#     db_product.description = product.description
#     db_product.price = product.price
#     db_product.image_url = product.image_url
    
#     db.commit()
#     db.refresh(db_product)
#     return db_product


# @app.get("/orders/", response_model=list[schemas.Order])
# def get_orders(db: Session = Depends(get_db)):
#     return db.query(models.Order).all()

    

# from fastapi import FastAPI, Depends, HTTPException
# from fastapi.middleware.cors import CORSMiddleware
# from sqlalchemy.orm import Session
# import models, schemas
# from database import Base, engine, get_db

# # Create all tables
# Base.metadata.create_all(bind=engine)

# app = FastAPI(title="Online Herbal Store API")

# # Allow frontend
# app.add_middleware(
#     CORSMiddleware,
#     allow_origins=["http://localhost:5173"],
#     allow_methods=["*"],
#     allow_headers=["*"]
# )

# # ---------------- Products ----------------
# @app.post("/products/", response_model=schemas.Product)
# def create_product(product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = models.Product(**product.dict())
#     db.add(db_product)
#     db.commit()
#     db.refresh(db_product)
#     return db_product

# @app.get("/products/", response_model=list[schemas.Product])
# def get_products(db: Session = Depends(get_db)):
#     return db.query(models.Product).all()

# @app.get("/products/{product_id}", response_model=schemas.Product)
# def get_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     return product

# @app.put("/products/{product_id}", response_model=schemas.Product)
# def update_product(product_id: int, product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     db_product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not db_product:
#         raise HTTPException(status_code=404, detail="Product not found")
    
#     db_product.name = product.name
#     db_product.description = product.description
#     db_product.price = product.price
#     db_product.image_url = product.image_url
    
#     db.commit()
#     db.refresh(db_product)
#     return db_product

# @app.delete("/products/{product_id}")
# def delete_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     db.delete(product)
#     db.commit()
#     return {"message": "Product deleted"}


# # ---------------- Users ----------------
# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     db_user = models.User(**user.dict())
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user

# @app.get("/users/", response_model=list[schemas.User])
# def get_users(db: Session = Depends(get_db)):
#     return db.query(models.User).all()

# # ---------------- Orders ----------------
# @app.post("/orders/", response_model=schemas.Order)
# def create_order(order: schemas.OrderCreate, db: Session = Depends(get_db)):
#     db_order = models.Order(user_id=order.user_id, total_price=order.total_price)
#     db.add(db_order)
#     db.commit()
#     db.refresh(db_order)

#     # Add order items
#     for item in order.items:
#         db_item = models.OrderItem(
#             order_id=db_order.id,
#             product_id=item.product_id,
#             quantity=item.quantity,
#             price=item.price
#         )
#         db.add(db_item)
#     db.commit()
#     return db_order

# @app.get("/orders/", response_model=list[schemas.Order])
# def get_orders(db: Session = Depends(get_db)):
#     return db.query(models.Order).all()



# from fastapi import FastAPI, Depends, HTTPException, Request
# from fastapi.middleware.cors import CORSMiddleware
# from fastapi.staticfiles import StaticFiles
# from sqlalchemy.orm import Session
# import models, schemas
# from database import Base, engine, get_db

# from fastapi.staticfiles import StaticFiles


# # Create all tables
# Base.metadata.create_all(bind=engine)

# app = FastAPI(title="Online Herbal Store API")

# # ✅ Serve static image files from backend/static/images
# # app.mount("/images", StaticFiles(directory="static/images"), name="images")

# # app.mount("/static", StaticFiles(directory="static"), name="static")
# app.mount("/static", StaticFiles(directory="static"), name="static")

# # ✅ Allow frontend connection (React Vite default port)
# app.add_middleware(
#     CORSMiddleware,
#     allow_origins=["http://localhost:5173"],
#     allow_methods=["*"],
#     allow_headers=["*"]
# )

# # ---------------- Products ----------------
# @app.post("/products/", response_model=schemas.Product)
# def create_product(product: schemas.ProductCreate, db: Session = Depends(get_db)):
#     """
#     Create a new product. 
#     Example: image_url should be only the filename, like 'coconut.jpg'
#     """
#     db_product = models.Product(**product.dict())
#     db.add(db_product)
#     db.commit()
#     db.refresh(db_product)
#     return db_product




# @app.get("/products/", response_model=list[schemas.Product])
# def get_products(request: Request, db: Session = Depends(get_db)):
#     """
#     Fetch all products and attach the full backend image URL.
#     Example output image_url: http://127.0.0.1:8000/images/coconut.jpg
#     """
#     products = db.query(models.Product).all()
#     for product in products:
#         if product.image_url:
#             product.image_url = f"{request.base_url}images/{product.image_url}"
#     return products



# @app.get("/products/{product_id}", response_model=schemas.Product)
# def get_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     return product


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


# @app.delete("/products/{product_id}")
# def delete_product(product_id: int, db: Session = Depends(get_db)):
#     product = db.query(models.Product).filter(models.Product.id == product_id).first()
#     if not product:
#         raise HTTPException(status_code=404, detail="Product not found")
#     db.delete(product)
#     db.commit()
#     return {"message": "Product deleted"}


# # ---------------- Users ----------------
# @app.post("/users/", response_model=schemas.User)
# def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
#     db_user = models.User(**user.dict())
#     db.add(db_user)
#     db.commit()
#     db.refresh(db_user)
#     return db_user


# @app.get("/users/", response_model=list[schemas.User])
# def get_users(db: Session = Depends(get_db)):
#     return db.query(models.User).all()




# # ---------------- Orders ----------------
# @app.post("/orders/", response_model=schemas.Order)
# def create_order(order: schemas.OrderCreate, db: Session = Depends(get_db)):
#     db_order = models.Order(user_id=order.user_id, total_price=order.total_price)
#     db.add(db_order)
#     db.commit()
#     db.refresh(db_order)

#     for item in order.items:
#         db_item = models.OrderItem(
#             order_id=db_order.id,
#             product_id=item.product_id,
#             quantity=item.quantity,
#             price=item.price
#         )
#         db.add(db_item)
#     db.commit()
#     return db_order


# @app.get("/orders/", response_model=list[schemas.Order])
# def get_orders(db: Session = Depends(get_db)):
#     return db.query(models.Order).all()

from fastapi import FastAPI, Depends, HTTPException, Request
from fastapi.middleware.cors import CORSMiddleware
from fastapi.staticfiles import StaticFiles
from sqlalchemy.orm import Session
import models, schemas
from database import Base, engine, get_db

from fastapi import UploadFile, File, Form
import shutil
import os

from fastapi import FastAPI
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


@app.put("/products/{product_id}", response_model=schemas.Product)
def update_product(product_id: int, product: schemas.ProductCreate, db: Session = Depends(get_db)):
    db_product = db.query(models.Product).filter(models.Product.id == product_id).first()
    if not db_product:
        raise HTTPException(status_code=404, detail="Product not found")
    
    db_product.name = product.name
    db_product.description = product.description
    db_product.price = product.price
    db_product.image_url = product.image_url  # store only filename
    
    db.commit()
    db.refresh(db_product)
    return db_product


@app.delete("/products/{product_id}")
def delete_product(product_id: int, db: Session = Depends(get_db)):
    product = db.query(models.Product).filter(models.Product.id == product_id).first()
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    db.delete(product)
    db.commit()
    return {"message": "Product deleted"}


# ---------------- Users ----------------
@app.post("/users/", response_model=schemas.User)
def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
    db_user = models.User(**user.dict())
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user


@app.get("/users/", response_model=list[schemas.User])
def get_users(db: Session = Depends(get_db)):
    return db.query(models.User).all()


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
    return db_order


@app.get("/orders/", response_model=list[schemas.Order])
def get_orders(db: Session = Depends(get_db)):
    return db.query(models.Order).all()

# admin Login

@app.post("/admin/login")
def admin_login(admin: schemas.AdminLogin, db: Session = Depends(get_db)):
    db_admin = db.query(models.Admin).filter(models.Admin.email == admin.email).first()
    if not db_admin or db_admin.password != admin.password:
        raise HTTPException(status_code=401, detail="Invalid email or password")
    return {"message": "Login successful", "admin_name": db_admin.admin_name}