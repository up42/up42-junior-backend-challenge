from typing import List, Optional
from pydantic import BaseModel

class Geometry(BaseModel):
    type: str
    coordinates: List[List[List[float]]]

class FeatureProperties(BaseModel):
    id: str
    timestamp: int

class Feature(BaseModel):
    type: str
    bbox: List[float]
    geometry: Optional[Geometry] = None
    properties: FeatureProperties

class FeatureCollection(BaseModel):
    type: str
    feature_list: Optional[List[Feature]] = None