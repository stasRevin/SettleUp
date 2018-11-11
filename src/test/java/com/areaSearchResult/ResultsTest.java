package com.areaSearchResult;

import com.areaSearchResult.Results;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testAreaSearchJson() {


        Client client = ClientBuilder.newClient();


        try {

            WebTarget target = client.target("http://localhost:8080/settleup/services/settleUpService/json/800/Art/0");

            String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            Results results = mapper.readValue(response, Results.class);

            System.out.println(results);
            assertEquals("?", results.getId());


        } catch (IOException ioException) {
            logger.error(ioException);
        }


    }
}