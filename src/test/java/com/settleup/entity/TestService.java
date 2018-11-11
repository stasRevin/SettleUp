package com.settleup.entity;

import com.areaSearchResult.Results;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testAreaSearchJson() {

        Client client = ClientBuilder.newClient();

        try {

            String urlJson = "http://localhost:8080/settleup/services/settleUpService/json/600/Art/0";

            WebTarget target = client.target(urlJson);

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            List<Results> results = mapper.reader().forType(new TypeReference<List<Results>>() {}).readValue(response);

            assertEquals("Bernalillo County", results.get(0).getCity());

        } catch (IOException ioException) {
            logger.error(ioException);
        }

    }

    @Test
    public void testAreaSearchXML() {


        Client client = ClientBuilder.newClient();


        try {

            String urlXML = "http://localhost:8080/settleup/services/settleUpService/xml/800/Art/0";

            WebTarget target = client.target(urlXML);

            String response = target.request(MediaType.APPLICATION_XML).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            List<Results> results = mapper.reader().forType(new TypeReference<List<Results>>() {}).readValue(response);

            assertEquals("Albany County", results.get(0).getCity());

        } catch (IOException ioException) {
            logger.error(ioException);
        }
    }

    @Test
    public void testAreaSearchText() {

        Client client = ClientBuilder.newClient();

        try {

            String urlText = "http://localhost:8080/settleup/services/settleUpService/text/800/Art/0";

            WebTarget target = client.target(urlText);

            String response = target.request(MediaType.TEXT_PLAIN).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            List<Results> results = mapper.reader().forType(new TypeReference<List<Results>>() {}).readValue(response);

            assertEquals("Albany County", results.get(0).getCity());

        } catch (IOException ioException) {
            logger.error(ioException);
        }
    }
}
