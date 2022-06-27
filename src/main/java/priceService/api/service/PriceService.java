package priceService.api.service;


import org.json.*;

import java.util.HashMap;
import java.util.Map;

public class PriceService {

    public int getPrice(JSONObject pizza) throws JSONException {
        JSONArray arr = pizza.getJSONArray("ingredients");
        int price = 0;
        for(int i = 0; i<arr.length(); i++) {
            price += arr.getJSONObject(i).getInt("price");
        }
        return price;
    }

    public int getPizzaId(JSONObject pizza) throws JSONException {
        return pizza.getInt("id");
    }

    public Map<Integer, Integer> getPizzaPrice(JSONObject pizza) throws JSONException {
        Map<Integer, Integer> pizzaPrice = new HashMap<>();
        pizzaPrice.put(getPizzaId(pizza), getPrice(pizza));
        return pizzaPrice;
    }

}
