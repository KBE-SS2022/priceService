package com.api.priceService.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import priceService.api.controller.PriceController;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceController.class)
@ContextConfiguration(classes ={PriceController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void testMockMvcCreation(){
        assertNotNull(mockMvc);
    }

}