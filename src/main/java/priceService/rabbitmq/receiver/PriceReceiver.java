package priceService.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import priceService.api.controller.PriceController;
import priceService.dto.PizzaDTO;
import priceService.rabbitmq.config.Constant;

import java.io.IOException;
import java.util.Map;

@Component
public class PriceReceiver {

   @Autowired
   PriceController priceController;

   @RabbitListener(queues = Constant.GET_PRICE_QUEUE)
   public Map<Long,Double> getPrice(@Payload PizzaDTO pizzaDTO, Channel channel) throws IOException {
      channel.basicAck(1L, true);
      ResponseEntity<Map<Long,Double>> entity;
      entity = priceController.getPizzaPrice(pizzaDTO);
      Map<Long,Double> pizzaPrice = entity.getBody();
      return pizzaPrice;
   }
}
