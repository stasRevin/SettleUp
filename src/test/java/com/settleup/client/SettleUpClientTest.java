package com.settleup.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import com.settleup.entity.SettleUp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettleUpClientTest {

    @Test
    public void testJson() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/800/Sports/2");

        String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<JSONResult> results = mapper.readValue(respone, new TypeReference<List<JSONResult>>(){});

        assertEquals(630, results.get(0).getRent1());
    }


   /** @Test
    public void testXML() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/xml/800/Sports/2");

        String respone = target.request(MediaType.APPLICATION_XML).get(String.class);
        JAXBContext jaxbContext = JAXBContext.newInstance(SettleUp.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SettleUp results = (SettleUp) unmarshaller.unmarshal("http://18.216.201.147:8080/settleup/services/settleUpService/xml/800/Sports/2");

        assertEquals("???", respone);
    }*/


}