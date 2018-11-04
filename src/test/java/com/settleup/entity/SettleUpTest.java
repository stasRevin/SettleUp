package com.settleup.entity;

import com.settleup.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getByPropertyEqualSuccess() {

        List<SettleUp> list = genericDAOSettleUp.getElementsAndClause("rent_0", 600, "activity", "running");
        assertEquals(2, list.size());
        assertEquals("running", list.get(0).getActivity());
        assertEquals("Cameron County",list.get(0).getCity());
        assertEquals("Hopkins County", list.get(1).getCity());


    }

}