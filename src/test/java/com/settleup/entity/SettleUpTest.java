package com.settleup.entity;

import com.settleup.persistence.GenericDAO;
import com.settleup.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}