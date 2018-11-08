package com.settleup.entity;

import com.settleUpService.SettleUpService;
import com.settleup.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SettleUpTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDAO<SettleUp> genericDAOSettleUp;

    @BeforeEach
    void setUp() {

        genericDAOSettleUp = new GenericDAO<>(SettleUp.class);

    }

    @Test
    void getPropertyByIdSuccess() {

        SettleUp retriedData = genericDAOSettleUp.getById(1);
        assertNotNull(retriedData);
        assertEquals("Callahan County", retriedData.getCity());

    }


    @Test
    void getElementsByRangeAndValuesSuccess() {

       List<SettleUp> results = genericDAOSettleUp.getElementsByRangeAndValues(600, 1500, "rent_0", "county", "Weston County");

       assertEquals(1, results.size());
    }
}