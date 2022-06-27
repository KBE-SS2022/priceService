package priceService.api.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import priceService.api.beanmaker.PriceServiceBean;
import priceService.api.service.PriceService;

import java.util.Map;

@RestController
@RequestMapping
public class PriceServiceController {

    private PriceService priceService = new PriceService();
    private JSONObject jsonObject;
    private PriceServiceBean priceServiceBean;

    private void unwrapper(PriceServiceBean priceServiceBean) {
        this.jsonObject = priceServiceBean.getJsonObject();
    }

    @GetMapping(path = "/price", produces = "application/json")
    public ResponseEntity<Map<Integer, Integer>> getPizzaPrice() throws JSONException {
        Map<Integer, Integer> pizzaPrice = priceService.getPizzaPrice(jsonObject);
        return new ResponseEntity<>(pizzaPrice, HttpStatus.OK);
    }
}
