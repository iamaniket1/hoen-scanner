package com.skyscanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    private static List<SearchResult> searchResults;

    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream carsStream = getClass().getResourceAsStream("/rental_cars.json");
             InputStream hotelsStream = getClass().getResourceAsStream("/hotels.json")) {
            List<SearchResult> cars = objectMapper.readValue(carsStream, new TypeReference<List<SearchResult>>() {});
            List<SearchResult> hotels = objectMapper.readValue(hotelsStream, new TypeReference<List<SearchResult>>() {});

            searchResults = cars;
            searchResults.addAll(hotels);
        }

        // Registering the search resource
        environment.jersey().register(new SearchResource());
    }

    public static List<SearchResult> getSearchResults() {
        return searchResults;
    }
}
