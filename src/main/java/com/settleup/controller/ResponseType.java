package com.settleup.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.settleup.client.JSONResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        urlPatterns = {"/responseType"}
)
public class ResponseType extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        Client client = ClientBuilder.newClient();

        String responseType = request.getParameter("returnType");
        String rent = request.getParameter("monthlyRent");
        String activity = request.getParameter("activity");
        String numberOfBedrooms = request.getParameter("numberOfBedrooms");

        String url = "http://18.216.201.147:8080/settleup/services/settleUpService/" + responseType + "/" + rent + "/" + activity + "/" + numberOfBedrooms;

        try {

            WebTarget target = client.target(url);
            String jsonResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();
            List<JSONResult> results = mapper.readValue(jsonResponse, new TypeReference<List<JSONResult>>(){});

            request.setAttribute("results", results);

            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } catch (IOException ioException) {
            logger.error(ioException);
        }


    }
}
