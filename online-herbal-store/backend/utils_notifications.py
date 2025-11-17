import smtplib
from email.mime.text import MIMEText
import requests
import os

# ---------------- EMAIL SENDER ----------------
def send_email(to_email: str, subject: str, message: str):
    sender = os.getenv("EMAIL_USER")
    password = os.getenv("EMAIL_PASS")

    msg = MIMEText(message)
    msg["Subject"] = subject
    msg["From"] = sender
    msg["To"] = to_email

    try:
        server = smtplib.SMTP("smtp.gmail.com", 587)
        server.starttls()
        server.login(sender, password)
        server.sendmail(sender, to_email, msg.as_string())
        server.quit()
        print("EMAIL USER:", os.getenv("EMAIL_USER"))
        print("EMAIL PASS:", os.getenv("EMAIL_PASS"))

        print("📧 Email sent successfully")

    except Exception as e:
        print("❌ Email send error:", e)


# ---------------- SMS SENDER (Fast2SMS) ----------------
def send_sms(phone: str, message: str):
    url = "https://www.fast2sms.com/dev/bulkV2"

    headers = {
        "authorization": os.getenv("SMS_API_KEY"),
        "Content-Type": "application/json"
    }

    payload = {
        "route": "v3",
        "sender_id": "TXTIND",
        "message": message,
        "language": "english",
        "flash": 0,
        "numbers": phone
    }

    try:
        response = requests.post(url, json=payload, headers=headers)
        print("📱 SMS sent:", response.json())
    except Exception as e:
        print("❌ SMS send error:", e)
