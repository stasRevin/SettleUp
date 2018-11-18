package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.settleup.entity.SettleUp;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SettleUpClient {


    public List<SettleUp> getJSONResults(int rent, String activity, int numberBedrooms) throws Exception {

        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/json/" + rent + "/" + activity + "/" + numberBedrooms;
        List<SettleUp> results = new ArrayList<>();
        String response = getResponse(MediaType.APPLICATION_JSON, targetUrl, results);

        if (results.size() > 0)
            return results;

        ObjectMapper mapper = new ObjectMapper();
        results = mapper.readValue(response, new TypeReference<List<SettleUp>>() {
        });

        return results;
    }

    /**
     * This methods produces results in XML format
     * @param rent
     * @param activity
     * @param numberBedrooms
     * @return
     * @throws Exception
     */
    public List<SettleUp> getXMLResults(int rent, String activity, int numberBedrooms) throws Exception {


        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/xml/" + rent + "/" + activity + "/" + numberBedrooms;

        List<SettleUp> results = new ArrayList<>();
        String response = getResponse(MediaType.APPLICATION_XML, targetUrl, results);

        if (results.size() > 0)
            return results;

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new StringReader(response));

        XmlMapper mapper = new XmlMapper();

        streamReader.next();

        results = mapper.readValue(streamReader, new TypeReference<List<SettleUp>>(){});

        streamReader.close();

        return results;
    }

    private String getResponse(String mediaType, String targetUrl, List<SettleUp> settleUpList) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetUrl);
        String response = "";

        try {
            response = target.request(mediaType).get(String.class);

        } catch (Exception exception) {

            SettleUp settleUpObject = new SettleUp();
            settleUpObject.setErrorMessage(exception.getMessage());
            settleUpList.add(settleUpObject);
        }

        return response;

    }


}
