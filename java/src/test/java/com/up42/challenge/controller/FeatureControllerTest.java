package com.up42.challenge.controller;

import com.up42.challenge.service.FeatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FeatureController.class)
public class FeatureControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FeatureService service;

    @Test
    void getFeaturesReturnsList() {
        // TODO
    }
}