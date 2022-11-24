package BookService.BookIntegration;

import BookService.dto.BookQueryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderToBookQuery {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(BookQueryDto bookQueryDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        String bookDtoToString;
        try {
            bookDtoToString = objectMapper.writeValueAsString(bookQueryDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        kafkaTemplate.send("sendBook", bookDtoToString);
    }
}
