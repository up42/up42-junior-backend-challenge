package com.up42.challenge.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.up42.challenge.model.Feature;
import com.up42.challenge.model.FeatureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FeatureService {

    @Autowired
    private ObjectMapper objectMapper;

    public List<FeatureCollection> parseJsonFile(String filePath) {
        try {
            String jsonContent = new String(new ClassPathResource("source-data.json")
                    .getInputStream()
                    .readAllBytes());

            return objectMapper.readValue(jsonContent, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Feature> loopExtractLoop() {
        ClassPathResource resource = new ClassPathResource("source-data.json");
        String resourcePath = resource.getPath(); // unused

        List<FeatureCollection> collections = parseJsonFile(resourcePath);

        List<List<Feature>> featuresNested = null;
        if (collections != null) {
            featuresNested = new ArrayList<>();
            for (FeatureCollection collection : collections) {
                if (collection.getFeatureList() != null && !collection.getFeatureList().isEmpty()) {
                    featuresNested.add(collection.getFeatureList());
                } else {
                    featuresNested.add(new ArrayList<>());
                }
            }
        }

        List<Feature> flatFeatures = new ArrayList<>();
        if (featuresNested != null && !featuresNested.isEmpty()) {
            for (List<Feature> group : featuresNested) {
                for (Feature item : group) {
                    if (item != null) {
                        flatFeatures.add(item);
                    }
                }
            }
        }

        return flatFeatures.isEmpty() ? Collections.emptyList() : flatFeatures;
    }
}