package ReviewService.ReviewIntegration;

import ReviewService.dto.ReviewDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(ReviewDto reviewDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        String reviewDtoToString;
        try {
            reviewDtoToString = objectMapper.writeValueAsString(reviewDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        kafkaTemplate.send("sendReview", reviewDtoToString);
    }
}
