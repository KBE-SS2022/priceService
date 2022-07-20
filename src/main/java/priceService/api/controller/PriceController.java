package priceService.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import priceService.api.dto.PizzaDTO;
import priceService.api.service.PriceService;

import java.util.Map;

@RestController
@RequestMapping
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping(path = "/price", produces = "application/json")
    public ResponseEntity<Map<Long,Double>> getPizzaPrice(PizzaDTO pizzaDTO) {
        Map<Long,Double> pizzaPrice = priceService.getPizzaPrice(pizzaDTO);
        return new ResponseEntity<>(pizzaPrice, HttpStatus.OK);
    }
}