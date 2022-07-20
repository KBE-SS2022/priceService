package priceService.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import priceService.api.controller.PriceController;
import priceService.api.dto.PizzaDTO;
import priceService.rabbitmq.config.Constant;

import java.util.Map;

@Component
public class PriceReceiver {

   @Autowired
   PriceController priceController;

   @RabbitListener(queues = Constant.GET_PRICE_QUEUE)
   public Map<Long,Double> getPrice(@Payload PizzaDTO pizzaDTO) {
      ResponseEntity<Map<Long,Double>> entity;
      try {
         entity = priceController.getPizzaPrice(pizzaDTO);
      } catch (Exception e) {
         System.out.println(e.getMessage());
         return null;
      }
      Map<Long,Double> pizzaPrice = entity.getBody();
      return pizzaPrice;
   }
}
