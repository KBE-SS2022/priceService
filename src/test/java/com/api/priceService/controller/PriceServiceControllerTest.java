package com.example.api.priceService.controller;

import com.example.api.priceService.controller.PriceServiceController;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.example.api.priceService.beanmaker.PriceServiceBean;
import com.example.api.priceService.service.PriceService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceServiceController.class)
@ContextConfiguration(classes ={PriceServiceController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void testMockMvcCreation(){
        assertNotNull(mockMvc);
    }

}