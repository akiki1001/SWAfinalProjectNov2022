package borrowingService.borrowingIntegration;


import borrowingService.borrowingServiceService.BorrowingService;

import borrowingService.dto.CustomerEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class CustomerReceiver {

    @Autowired
    private BorrowingService borrowingService;

    @KafkaListener(id = "customerListen" ,topics = "sendCustomer")
    public void receive(@Payload String eventEventString,
                        @Headers MessageHeaders headers) {
        ObjectMapper objectMapper=new ObjectMapper();

        CustomerEvent customerEvent=null;
        try {
            customerEvent = objectMapper.readValue(eventEventString, CustomerEvent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

            borrowingService.updateCustomer(customerEvent);

    }

}