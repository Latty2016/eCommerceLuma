package com.qa.apiPayload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayLoad {

    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonProperty("websiteId")
    private int websiteId;

    public CustomerPayLoad(String customerEmail, int websiteId) {
        this.customerEmail = customerEmail;
        this.websiteId = websiteId;
    }
}
