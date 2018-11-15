package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettleUpClientTest {

    @Test
    public void testJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/800/Sports/2");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<SettleUp> results = mapper.readValue(response, new TypeReference<List<SettleUp>>(){});

        assertEquals(630, results.get(0).getRent_1());
    }


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


}