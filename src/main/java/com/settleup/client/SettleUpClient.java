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

/**
 * This is the SettleUpClient designed to consume the application's service to get apartment search results
 * in either XML or JSON format.
 * @author kkoberle
 */
public class SettleUpClient {

    /**
     * This method produces JSON results.
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberBedrooms Number of bedrooms
     * @return results The list of the apartment search results.
     * @throws Exception The generic exception.
     */
    public List<SettleUp> getJSONResults(int rent, String activity, int numberBedrooms) throws Exception {

        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/json/"
                + rent + "/" + activity + "/" + numberBedrooms;
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
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberBedrooms Number of bedrooms.
     * @return results The list of the apartment search results.
     * @throws Exception Generic exception.
     */
    public List<SettleUp> getXMLResults(int rent, String activity, int numberBedrooms) throws Exception {

        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/xml/"
                + rent + "/" + activity + "/" + numberBedrooms;
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

    /**
     * This method produces the response from the service.
     * @param mediaType The type of the media.
     * @param targetUrl The target URL
     * @param settleUpList The list of SettleUp objects.
     * @return response
     */
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
