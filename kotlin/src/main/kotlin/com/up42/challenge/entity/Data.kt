package com.up42.challenge.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Geometry(
    val type: String,
    val coordinates: List<List<List<Double>>>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeatureProperties(
    val id: String,
    val timestamp: Long,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Feature(
    val type: String,
    val bbox: List<Double>,
    val geometry: Geometry,
    val properties: FeatureProperties
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeatureCollection(
    val type: String,
    val featureList: List<Feature>?
)
