package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettleUpClientTest {

    @Test
    public void testJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/800/Sports/2");

        String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<JSONResult> results = mapper.readValue(respone, new TypeReference<List<JSONResult>>(){});

        assertEquals(633, results.get(0).getRent1());
    }

    @Test
    public void testXML() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/xml/800/Sports/2");

        String respone = target.request(MediaType.APPLICATION_XML).get(String.class);


        assertEquals("???", respone);

    }
}