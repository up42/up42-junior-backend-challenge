package com.up42.challenge.service

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.up42.challenge.entity.Feature
import com.up42.challenge.entity.FeatureCollection
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class FeatureService(private val objectMapper: ObjectMapper) {

    fun parseJsonFile(filePath: String): List<FeatureCollection>? {
        val jsonContent = ClassPathResource("source-data.json")
            .inputStream.bufferedReader().readText()
        return objectMapper.readValue(jsonContent, object : TypeReference<List<FeatureCollection>>() {})
    }

    fun loopExtractLoop(): List<Feature> {
        val resource = ClassPathResource("source-data.json")
        val resourcePath = resource.path

        val collections = parseJsonFile(resourcePath)

        val featuresNested: List<List<Feature?>>? = collections?.map { collection ->
            if (collection.featureList != null && collection.featureList.isNotEmpty()) {
                collection.featureList
            } else {
                emptyList()
            }
        }

        val flatFeatures = mutableListOf<Feature>()
        if (featuresNested != null && featuresNested.isNotEmpty()) {
            for (group in featuresNested) {
                for (item in group) {
                    if (item != null) {
                        flatFeatures.add(item)
                    }
                }
            }
        }

        return if (flatFeatures.isEmpty()) {
            listOf()
        } else {
            flatFeatures
        }
    }
}
