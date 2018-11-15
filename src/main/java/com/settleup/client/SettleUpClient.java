package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.settleup.entity.SettleUp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class SettleUpClient {

    public List<SettleUp> getJSONRestuls(int rent, String activity, int numberBedrooms) throws Exception {
        Client client = ClientBuilder.newClient();
        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/json/" + rent + "/" + activity + "/" + numberBedrooms;
        WebTarget target = client.target(targetUrl);

        String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<SettleUp> results = mapper.readValue(respone, new TypeReference<List<SettleUp>>() {
        });

        return results;
    }

    public List<SettleUp> getXMLResults(int rent, String activity, int numberBedrooms) throws Exception {
        Client client = ClientBuilder.newClient();
        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/json/" + rent + "/" + activity + "/" + numberBedrooms;
        WebTarget target = client.target(targetUrl);

        String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<SettleUp> results = mapper.readValue(respone, new TypeReference<List<SettleUp>>() {
        });

        return results;


    }

}
