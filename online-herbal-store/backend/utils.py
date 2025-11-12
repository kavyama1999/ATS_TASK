from passlib.context import CryptContext

# ✅ Use Argon2 instead of bcrypt (no backend errors, very secure)
pwd_context = CryptContext(schemes=["argon2"], deprecated="auto")

def hash_password(password: str) -> str:
    """Hash the password securely using Argon2."""
    return pwd_context.hash(password)

def verify_password(plain_password: str, hashed_password: str) -> bool:
    """Verify a plain password against the stored Argon2 hash."""
    return pwd_context.verify(plain_password, hashed_password)
