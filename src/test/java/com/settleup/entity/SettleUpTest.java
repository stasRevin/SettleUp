package com.settleup.entity;

import com.settleup.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SettleUpTest {

    //private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO<SettleUp> genericDAOSettleUp;

    @BeforeEach
    void setUp() {

        genericDAOSettleUp = new GenericDAO<>(SettleUp.class);

    }

    @Test
    void getPropertyByIdSuccess() {

        SettleUp retriedData = genericDAOSettleUp.getById(51);
        assertNotNull(retriedData);
        assertEquals("Deschutes County", retriedData.getCity());

    }

    @Test
    void getAllSuccess() {

        Set<String> activitySet = new HashSet<>();
        List<SettleUp> allData =  genericDAOSettleUp.getAll();

        for ( SettleUp list : allData) {
            activitySet.add(list.getActivity());
        }
        assertEquals("Sports", allData.get(0).getActivity());
        assertEquals(10, activitySet.size());
    }
    
    @Test
    void getElementsByRangeAndValuesSuccess() {

       List<SettleUp> results = genericDAOSettleUp.getElementsByRangeAndValues(600, 1500, "rent_0", "county", "Cameron County");

       assertEquals(1, results.size());
    }
}