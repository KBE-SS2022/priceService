package priceService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Long id;
    private String name;
    private String brand;
    private String countryOrigin;
    private char nutritionScore;
    private Integer calories;
    private Integer amount;
    private Double weight;
    private Double price;
}