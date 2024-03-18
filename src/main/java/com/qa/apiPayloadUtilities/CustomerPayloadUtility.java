package com.qa.apiPayloadUtilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.apiPayload.CustomerPayLoad;

public class CustomerPayloadUtility {
    public static String getCustomerPayload(){
        String payLoad=null;
        CustomerPayLoad customerPayLoad = new CustomerPayLoad("yusuf@gmail.com",0);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValueAsString(customerPayLoad);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payLoad;
    }


}
