package com.settleup.controller;


import com.areaSearchResult.Results;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@WebServlet(
        urlPatterns = {"/areaSearch"}
)
public class AreaSearch extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String monthlyRent = request.getParameter("monthlyRent");
        String numberOfBedrooms = request.getParameter("numberOfBedrooms");
        String activity = request.getParameter("activity");
        String returnType = request.getParameter("returnType");

        String url = "http://localhost:8080/settleup/services/settleUpService/" + returnType + "/" + monthlyRent + "/" + activity + "/" + numberOfBedrooms;

        RequestDispatcher dispatcher;

        Client client = ClientBuilder.newClient();


        try {

            WebTarget target = client.target(url);

            String serviceResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            List<Results> results = mapper.reader().forType(new TypeReference<List<Results>>() {}).readValue(serviceResponse);

            request.setAttribute("cities", results);

            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);


        } catch (IOException ioException) {
            logger.error(ioException);
        }






    }

}
