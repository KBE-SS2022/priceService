package priceService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {

    private Long id;
    private String name;
    private Map<Long,Double> ingredientIdToPrice;
}