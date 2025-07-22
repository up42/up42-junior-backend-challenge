package com.up42.challenge.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class FeatureServiceTest {

    @Autowired
    private lateinit var service: FeatureService

    @Test
    fun `loads three features from resource`() {
        // TODO
    }
}