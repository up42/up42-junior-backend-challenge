from fastapi import FastAPI
from src.controller import router

app = FastAPI()
app.include_router(router)