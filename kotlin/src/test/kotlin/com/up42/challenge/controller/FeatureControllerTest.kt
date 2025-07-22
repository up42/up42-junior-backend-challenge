package com.up42.challenge.controller

import com.up42.challenge.service.FeatureService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.mock.mockito.MockBean

@WebMvcTest(FeatureController::class)
class FeatureControllerTest {

    @Autowired private lateinit var mvc: MockMvc
    @MockBean private lateinit var service: FeatureService

    @Test
    fun `GET features returns list`() {
        // TODO
    }
}