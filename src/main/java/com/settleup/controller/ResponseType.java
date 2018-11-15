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

import com.settleup.client.SettleUpClient;
import com.settleup.entity.SettleUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        urlPatterns = {"/responseType"}
)
public class ResponseType extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SettleUpClient settleClient;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        Client client = ClientBuilder.newClient();

        String responseType = request.getParameter("returnType");
        int rent = Integer.parseInt(request.getParameter("monthlyRent"));
        String activity = request.getParameter("activity");
        int numberOfBedrooms = Integer.parseInt(request.getParameter("numberOfBedrooms"));

        if ( responseType == "json") {
            try {

                List<SettleUp> results = settleClient.getJSONRestuls(rent, activity, numberOfBedrooms);
                request.setAttribute("results", results);

                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);

            } catch (IOException ioException) {
                logger.error(ioException);
            } catch (Exception exception) {
                logger.error(exception);
            }

        } else if ( responseType == "xml") {

            try {

                List<SettleUp> results = settleClient.getXMLResults(rent, activity, numberOfBedrooms);
                request.setAttribute("results", results);

                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);

            } catch (IOException ioException) {
                logger.error(ioException);
            } catch (Exception exception) {
                logger.error(exception);
            }
        }


    }
}
