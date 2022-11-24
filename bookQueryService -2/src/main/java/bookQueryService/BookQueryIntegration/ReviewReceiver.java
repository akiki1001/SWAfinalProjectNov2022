package bookQueryService.BookQueryIntegration;


import bookQueryService.bookQueryService.BookQueryService;
import bookQueryService.dto.ReviewDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReviewReceiver {

    @Autowired
    private BookQueryService bookQueryService;

    @KafkaListener(id = "reviewListen" ,topics = "sendReview")
    public void receive(@Payload String reviewDtoString,
                        @Headers MessageHeaders headers) {
        ObjectMapper objectMapper=new ObjectMapper();
        ReviewDto reviewDto = null;
        try {
            reviewDto = objectMapper.readValue(reviewDtoString, ReviewDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        bookQueryService.addReview(reviewDto);
        //System.out.println("received message="+ sensorRecord.toString());
    }

}