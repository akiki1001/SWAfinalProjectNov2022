package BookService.BookIntegration;

import BookService.dto.BookEvent;
import BookService.dto.BookQueryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendToBorrowing {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(BookEvent bookEvent) {
        ObjectMapper objectMapper = new ObjectMapper();
        String bookEventDtoToString;
        try {
            bookEventDtoToString = objectMapper.writeValueAsString(bookEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        kafkaTemplate.send("updateBookInBorrowing", bookEventDtoToString);
    }
}
