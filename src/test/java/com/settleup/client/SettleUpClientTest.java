package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import com.settleup.entity.SettleUp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.StringReader;

import java.util.List;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to test service implementation. (Json, XML)
 * Test exception handling.
 * @kkoberle
 * @oponomarova
 */
class SettleUpClientTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Method to test service to return json object with the rent price
     * @throws Exception
     */
    @Test
    public void testJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/800/Sports/2");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<SettleUp> results = mapper.readValue(response, new TypeReference<List<SettleUp>>(){});

        assertEquals(630, results.get(0).getRent_1());
    }

    /**
     * This method tests whether the service returns the output in the text format.
     */
    @Test
    public void testText() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/text/800/Sports/2");

        String response = target.request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals(true, response.contains("SettleUp(id=45, rent_0=535, rent_1=630, rent_2=833, rent_3=1104"));

    }


    /**
     * Method to test service to return xml object with the rent price
     * @throws Exception
     */
    @Test
    public void testXML() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/xml/800/Sports/2");
        String response = target.request(MediaType.APPLICATION_XML).get(String.class);

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new StringReader(response));

        XmlMapper mapper = new XmlMapper();

        streamReader.next();

        List<SettleUp> results = mapper.readValue(streamReader, new TypeReference<List<SettleUp>>(){});

        streamReader.close();

        assertEquals(630, results.get(0).getRent_1());
    }


    /**
     * Method to test if 404 exception been thrown by the service
     * if user enters rent price that does not exist.
     * Test json type request
     */
    @Test
    public void getResponseExceptionJsonSuccess() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/8000/Sports/2");

        try {
            assertThrows(javax.ws.rs.NotFoundException.class, () ->  target.request(MediaType.APPLICATION_JSON).get(String.class));

        } catch (Exception exception) {
            logger.error(exception);
        }

    }


    /**
     * Method to test if 404 exception been thrown by the service
     * if user enters rent price that does not exist.
     * Test xml type request
     */
    @Test
    public void getResponseExceptionXMLSuccess() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/xml/8000/Sports/2");

        try {
            assertThrows(javax.ws.rs.NotFoundException.class, () ->  target.request(MediaType.APPLICATION_XML).get(String.class));

        } catch (Exception exception) {
            logger.error(exception);
        }

    }
}