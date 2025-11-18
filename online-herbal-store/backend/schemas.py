from pydantic import BaseModel
from typing import Optional
from datetime import datetime  
from pydantic import Field



# Product Schemas
class ProductBase(BaseModel):
    name: str
    description: str
    price: float
    # image_url: str
    image_url: Optional[str] = None  # ✅ make optional


class ProductCreate(ProductBase):
    pass

class Product(ProductBase):
    id: int
    class Config:
        orm_mode = True

# User Schemas
class UserBase(BaseModel):
    username: str
    email: str | None = None
    password: str

    # 🆕 NEW FIELDS
    address: Optional[str] = None
    # contact_number: Optional[str] = None
    # VALIDATED CONTACT NUMBER (EXACTLY 10 DIGITS)
    contact_number: str = Field(
    ...,
    min_length=10,
    max_length=10,
    pattern="^[0-9]{10}$"
)

# class UserUpdate(BaseModel):
#     username: str | None = None
#     email: str | None = None
#     address: str | None = None
#     contact_number: str | None = None



class UserCreate(UserBase):
    # is_admin: bool = False
    pass  

class User(UserBase):
    id: int
    profile_image: Optional[str] = None   # MUST match database column
    image_url: Optional[str] = None       # computed full URL (new!)
  


    class Config:
        orm_mode = True

# User Login Schema
class UserLogin(BaseModel):
    email: str
    password: str       

# OrderItem Schemas
class OrderItemBase(BaseModel):
    product_id: int
    quantity: int
    price: float

class OrderItemCreate(OrderItemBase):
    pass

class OrderItem(OrderItemBase):
    id: int
    class Config:
        orm_mode = True

# Order Schemas
class OrderBase(BaseModel):
    user_id: int
    total_price: float

class OrderCreate(OrderBase):
    items: list[OrderItemCreate]

class Order(OrderBase):
    id: int
    # order_date: str
    order_date: datetime  
    items: list[OrderItem] = []
    username: Optional[str] = None   # ✅ Added
    email: Optional[str] = None      # ✅ Added
    class Config:
        orm_mode = True

# AdminLogin
class AdminLogin(BaseModel):
    email: str
    password: str