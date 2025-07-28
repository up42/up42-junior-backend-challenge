import json
from typing import List
from src.models import Feature, FeatureCollection
from pathlib import Path

def parse_json_file(file_path: str) -> List[FeatureCollection]:
    json_path = Path(__file__).parent / "data" / "source-data.json"
    with open(json_path, encoding="utf-8") as f:
        raw_data = json.load(f)

    return [FeatureCollection(**fc) for fc in raw_data]

def loop_extract_loop() -> List[Feature]:
    collections = parse_json_file("source-data.json")
    features_nested = [
        collection.feature_list if collection.feature_list else []
        for collection in collections if collection is not None
    ]

    flat_features = []
    for group in features_nested:
        for item in group:
            if item is not None:
                flat_features.append(item)

    return flat_features if flat_features else []