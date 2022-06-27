package priceService.api.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {

    PriceService priceService;
    JSONObject jsonObject;

    @BeforeEach
    public void init() throws JSONException {
        String pizza = "{\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"Salami\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Salami\",\n" +
                "      \"brand\": \"string\",\n" +
                "      \"countryOrigin\": \"string\",\n" +
                "      \"nutritionScore\": \"string\",\n" +
                "      \"calories\": 0,\n" +
                "      \"amount\": 0,\n" +
                "      \"weight\": 0,\n" +
                "      \"price\": 14,\n" +
                "      \"pizzas\": [\n" +
                "        \"string\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Cheese\",\n" +
                "      \"brand\": \"string\",\n" +
                "      \"countryOrigin\": \"string\",\n" +
                "      \"nutritionScore\": \"string\",\n" +
                "      \"calories\": 0,\n" +
                "      \"amount\": 0,\n" +
                "      \"weight\": 0,\n" +
                "      \"price\": 10,\n" +
                "      \"pizzas\": [\n" +
                "        \"string\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Bread\",\n" +
                "      \"brand\": \"string\",\n" +
                "      \"countryOrigin\": \"string\",\n" +
                "      \"nutritionScore\": \"string\",\n" +
                "      \"calories\": 0,\n" +
                "      \"amount\": 0,\n" +
                "      \"weight\": 0,\n" +
                "      \"price\": 5,\n" +
                "      \"pizzas\": [\n" +
                "        \"string\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        priceService = new PriceService();
        jsonObject = new JSONObject(pizza);
    }

    @Test
    public void getPizzaIdTest() throws JSONException {
        assertEquals(0, priceService.getPizzaId(jsonObject));
    }

    @Test
    public void getPriceTest() throws JSONException {
        assertEquals(29, priceService.getPrice(jsonObject));
    }

    @Test
    public void getPizzaPriceTest1() throws JSONException {
        Map<Integer, Integer> idPriceMap = new HashMap<>();
        idPriceMap.put(0, 29);
        for(int i = 0; i < idPriceMap.size(); i++) {
            assertEquals(idPriceMap.get(i), priceService.getPizzaPrice(jsonObject).get(i));
        }
    }

}