from pydantic import BaseModel

# Product Schemas
class ProductBase(BaseModel):
    name: str
    description: str
    price: float
    image_url: str

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

class UserCreate(UserBase):
    is_admin: bool = False

class User(UserBase):
    id: int
    class Config:
        orm_mode = True

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
    order_date: str
    items: list[OrderItem] = []
    class Config:
        orm_mode = True

# AdminLogin
class AdminLogin(BaseModel):
    email: str
    password: str