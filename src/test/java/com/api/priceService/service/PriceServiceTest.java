package com.api.priceService.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import priceService.dto.PizzaDTO;
import priceService.api.service.PriceService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {

    PriceService priceService;
    PizzaDTO pizzaDTO;

    @BeforeEach
    public void init()  {
        pizzaDTO = new PizzaDTO(1L, "Salami",
                Map.of(10101L, 1.00, 10102L, 2.50, 10105L, 1.50));

        priceService = new PriceService();
    }

    @Test
    public void getPizzaIdTest() {
        assertEquals(1L, priceService.getPizzaId(pizzaDTO));
    }

    @Test
    public void getPriceTest() {
        assertEquals(5.0, priceService.getPrice(pizzaDTO));
    }

    @Test
    public void getPizzaPriceTest1() {
        Map<Long,Double> idPriceMap = Map.of(1l, 5.0);
        assertEquals(idPriceMap, priceService.getPizzaPrice(pizzaDTO));
    }
}