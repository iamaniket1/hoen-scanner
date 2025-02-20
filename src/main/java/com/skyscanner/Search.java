package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    @JsonProperty
    private String city;

    // Default constructor (required for Jackson)
    public Search() {
    }

    // Constructor with city parameter
    public Search(String city) {
        this.city = city;
    }

    // Getter method
    public String getCity() {
        return city;
    }

    // Setter method
    public void setCity(String city) {
        this.city = city;
    }
}
