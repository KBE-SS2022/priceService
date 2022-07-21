package priceService.api.service;

import org.springframework.stereotype.Service;
import priceService.dto.PizzaDTO;

import java.util.HashMap;
import java.util.Map;

@Service
public class PriceService {

    public double getPrice(PizzaDTO pizza) {
        Map<Long,Double> ingredientIdToPrice = pizza.getIngredientIdToPrice();
        double price = ingredientIdToPrice.values()
                .stream()
                .reduce(0.0, Double::sum);
        return price;
    }

    public long getPizzaId(PizzaDTO pizza) {
        return pizza.getId();
    }

    public Map<Long,Double> getPizzaPrice(PizzaDTO pizza) {
        Map<Long,Double> pizzaPrice = new HashMap<>();
        pizzaPrice.put(getPizzaId(pizza), getPrice(pizza));
        return pizzaPrice;
    }
}