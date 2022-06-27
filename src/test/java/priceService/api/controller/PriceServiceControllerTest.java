package priceService.api.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import priceService.api.beanmaker.PriceServiceBean;
import priceService.api.service.PriceService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceServiceController.class)
@ContextConfiguration(classes = {PriceServiceController.class})
class PriceServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PriceService priceService;
    @InjectMocks
    private PriceServiceBean priceServiceBean;

    private JSONObject j;

    private String getPriceByPath = "/price";

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

        j = new JSONObject(pizza);
        priceServiceBean = new PriceServiceBean();
        priceServiceBean.setJsonObject(j);
    }

    @Test
    void testMockMvcCreation(){
        assertNotNull(mockMvc);
    }

    @Test
    public void fr() throws Exception {
        when(this.priceService.getPizzaPrice(j)).thenReturn(Map.of(0, 29));
        this.mockMvc.perform(get(this.getPriceByPath).contentType("application/json"))
                .andExpect(status().isOk());

        Mockito.verify(priceService);
    }

}