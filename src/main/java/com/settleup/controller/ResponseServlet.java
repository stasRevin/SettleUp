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
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        SettleUpClient settleClient = new SettleUpClient();

        String responseType = request.getParameter("returnType");
        String rentString = request.getParameter("monthlyRent").trim();
        String activity = request.getParameter("activity");
        int numberOfBedrooms = Integer.parseInt(request.getParameter("numberOfBedrooms"));

        if ( rentString.equals("")) {

            request.setAttribute("form", "empty");
            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } else {

            int rent = Integer.parseInt(rentString);
            if ( responseType.equals("json")) {
                try {

                    List<SettleUp> results = settleClient.getJSONResults(rent, activity, numberOfBedrooms);
                    request.setAttribute("results", results);
                    request.setAttribute("bedrooms", numberOfBedrooms);
                    request.setAttribute("price", rent);

                    dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);

                } catch (IOException ioException) {
                    logger.error(ioException);
                } catch (Exception exception) {
                    logger.error(exception);
                }

            } else if ( responseType.equals("xml")) {

                try {
                    List<SettleUp> results = settleClient.getXMLResults(rent, activity, numberOfBedrooms);
                    request.setAttribute("results", results);
                    request.setAttribute("bedrooms", numberOfBedrooms);
                    request.setAttribute("price", rent);

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
}
