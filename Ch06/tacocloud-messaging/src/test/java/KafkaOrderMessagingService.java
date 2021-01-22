import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import tacos.Order;

public class KafkaOrderMessagingService implements OrderMessagingService{
    @Autowired
    private KafkaTemplate<String,Order> kafkaTemplate;
    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send("tacocloud.orders.topic",order);
    }
}
