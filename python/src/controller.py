from fastapi import APIRouter
from src.service import loop_extract_loop
from src.models import Feature
from typing import List

router = APIRouter()

@router.get("/features", response_model=List[Feature])
def get_features():
    return loop_extract_loop()