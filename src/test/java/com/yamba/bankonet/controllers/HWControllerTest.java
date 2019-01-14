package com.yamba.bankonet.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HWControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldSayHello() {
        HWController hw = new HWController();
        assertEquals("Bienvenue sur Bankonet ",hw.sayHello());
    }
}