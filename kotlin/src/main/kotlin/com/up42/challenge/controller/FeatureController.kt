package com.up42.challenge.controller


import com.up42.challenge.entity.Feature
import com.up42.challenge.service.FeatureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureController(private val featureService: FeatureService) {



    @GetMapping("/features")
    fun getFeatures(): List<Feature> {
        return featureService.loopExtractLoop()
    }
}
