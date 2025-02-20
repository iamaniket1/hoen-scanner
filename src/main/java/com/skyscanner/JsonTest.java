package com.skyscanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating a Search object and converting it to JSON
            Search search = new Search("Petalborough");
            String searchJson = objectMapper.writeValueAsString(search);
            System.out.println("Search Object to JSON: " + searchJson);

            // Converting JSON back to a Search object
            Search deserializedSearch = objectMapper.readValue(searchJson, Search.class);
            System.out.println("JSON to Search Object: " + deserializedSearch.getCity());

            // Creating a SearchResult object and converting it to JSON
            SearchResult searchResult = new SearchResult("Petalborough", "hotel", "Grand Plaza");
            String searchResultJson = objectMapper.writeValueAsString(searchResult);
            System.out.println("SearchResult Object to JSON: " + searchResultJson);

            // Converting JSON back to a SearchResult object
            SearchResult deserializedResult = objectMapper.readValue(searchResultJson, SearchResult.class);
            System.out.println("JSON to SearchResult Object: " + deserializedResult.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
