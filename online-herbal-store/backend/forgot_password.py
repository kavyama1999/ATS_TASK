from fastapi import APIRouter, HTTPException
from pydantic import BaseModel
from sqlalchemy.orm import Session
from database import SessionLocal
from models import User
import random
import string

from utils.email_sms import send_email
from utils.password_utils import hash_password

router = APIRouter()


# ---------------------- HELPERS ----------------------

def generate_otp():
    return ''.join(random.choices(string.digits, k=6))


# ---------------------- REQUEST MODELS ----------------------

class EmailRequest(BaseModel):
    email: str


class OTPVerify(BaseModel):
    email: str
    otp: str


class ResetPassword(BaseModel):
    email: str
    new_password: str


# ---------------------- 1️⃣ SEND OTP ----------------------

@router.post("/forgot-password/")
def forgot_password(request: EmailRequest):
    db: Session = SessionLocal()
    user = db.query(User).filter(User.email == request.email).first()

    if not user:
        raise HTTPException(status_code=404, detail="Email not registered")

    otp = generate_otp()
    user.reset_otp = otp
    db.commit()

    # Send email using your function
    send_email(
        to_email=request.email,
        subject="Password Reset OTP",
        message=f"Your OTP to reset password is: {otp}"
    )

    return {"message": "OTP sent to email"}


# ---------------------- 2️⃣ VERIFY OTP ----------------------

@router.post("/verify-otp/")
def verify_otp(data: OTPVerify):
    db: Session = SessionLocal()

    user = db.query(User).filter(
        User.email == data.email,
        User.reset_otp == data.otp
    ).first()

    if not user:
        raise HTTPException(status_code=400, detail="Invalid OTP")

    return {"message": "OTP verified"}


# ---------------------- 3️⃣ RESET PASSWORD ----------------------

@router.post("/reset-password/")
def reset_password(data: ResetPassword):
    db: Session = SessionLocal()
    user = db.query(User).filter(User.email == data.email).first()

    if not user:
        raise HTTPException(status_code=404, detail="User does not exist")

    hashed = hash_password(data.new_password)
    user.password = hashed
    user.reset_otp = None
    db.commit()

    return {"message": "Password updated successfully"}
