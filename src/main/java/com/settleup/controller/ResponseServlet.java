package com.settleup.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.settleup.client.SettleUpClient;
import com.settleup.entity.SettleUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet to return service response based on the user selection.
 * @author oponomarova
 */

@WebServlet(name = "ResponseServlet",
        urlPatterns = {"/responseServlet"}
)
public class ResponseServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Method to retrieve city based on the user incoming input from the POST form
     * method forwards result to the index page for display
     * method validates user input
     * @param request The HttpRequest.
     * @param response The HttpResponse.
     * @throws ServletException Servlet exception.
     * @throws IOException Input output exception.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String responseType = request.getParameter("returnType");
        String rentString = request.getParameter("monthlyRent").trim();
        String activity = request.getParameter("activity");
        int numberOfBedrooms = Integer.parseInt(request.getParameter("numberOfBedrooms"));

        if (rentString.equals("")) {

            request.setAttribute("form", "empty");
            forward(request, response);

        } else {

            try {

                List<SettleUp> results = getResults(responseType, rentString, activity, numberOfBedrooms);
                request.setAttribute("results", results);
                request.setAttribute("bedrooms", numberOfBedrooms);
                request.setAttribute("price", rentString);

            } catch (Exception exception) {

                logger.debug("Exception {}", exception);
            }

            forward(request, response);
        }
    }

    /**
     * This method forward request and response to the view page.
     * @param request HttpRequest
     * @param response HttpResponse
     * @throws IOException Input output exception
     * @throws ServletException Servlet exception
     */
    private void forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * This method gets service results.
     * @param responseType The response type.
     * @param rentInput The rent price.
     * @param activity The activity name.
     * @param numberOfBedrooms Number of bedrooms.
     * @return
     * @throws Exception A generic service exception.
     */
    private List<SettleUp> getResults(String responseType, String rentInput, String activity, int numberOfBedrooms)
                throws Exception {

        SettleUpClient settleClient = new SettleUpClient();
        int rent = Integer.parseInt(rentInput);
        List<SettleUp> results = null;

        if (responseType.equals("json")) {

            results = settleClient.getJSONResults(rent, activity, numberOfBedrooms);

        } else if (responseType.equals("xml")) {

            results = settleClient.getXMLResults(rent, activity, numberOfBedrooms);

        }

        return results;
    }

}
