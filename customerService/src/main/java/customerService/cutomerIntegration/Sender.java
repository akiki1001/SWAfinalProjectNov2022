package customerService.cutomerIntegration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import customerService.dto.CustomerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(CustomerEvent customerEvent) {
        ObjectMapper objectMapper = new ObjectMapper();
        String customerDtoToString;
        try {
            customerDtoToString = objectMapper.writeValueAsString(customerEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        kafkaTemplate.send("sendCustomer", customerDtoToString);
    }
}
