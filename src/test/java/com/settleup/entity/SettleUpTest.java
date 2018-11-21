package com.settleup.entity;

import com.settleup.persistence.GenericDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test service DAO to get city based on id, to get all data,
 * to get data based on the price range
 * @author oponomarova
 * @author srevin
 */
class SettleUpTest {

    GenericDAO<SettleUp> genericDAOSettleUp;

    /**
     * method to get instantiate generic dao for each method.
     */
    @BeforeEach
    void setUp() {

        genericDAOSettleUp = new GenericDAO<>(SettleUp.class);

    }

    /**
     * Method to get the city based on the id.
     */
    @Test
    void getPropertyByIdSuccess() {

        SettleUp retriedData = genericDAOSettleUp.getById(51);
        assertNotNull(retriedData);
        assertEquals("Deschutes County", retriedData.getCity());

    }

    /**
     * Method to test retrieving all the items from the database
     * and storing all the activities into the set
     */
    @Test
    void getAllSuccess() {

        Set<String> activitySet = new HashSet<>();
        List<SettleUp> allData =  genericDAOSettleUp.getAll();

        for ( SettleUp list : allData) {
            activitySet.add(list.getActivity());
        }
        assertEquals("Art", allData.get(0).getActivity());
        assertEquals(11, activitySet.size());
    }

    /**
     * Method to retrieve city based on the rent range, number of bedrooms, city
     */
    @Test
    void getElementsByRangeAndValuesSuccess() {

       List<SettleUp> results = genericDAOSettleUp.getElementsByRangeAndValues(600, 1500, "rent_0", "county", "Cameron County");

       assertEquals(1, results.size());
    }
}