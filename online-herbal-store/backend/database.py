from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

# MySQL database URL: replace with your username, password, database
# DATABASE_URL = "mysql+pymysql://root:YOUR_PASSWORD@localhost/herbal_store"
DATABASE_URL = "mysql+pymysql://root:root@localhost:3306/herbal_store"

engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
