package bookQueryService.BookQueryIntegration;


import bookQueryService.bookQueryService.BookQueryService;
import bookQueryService.dto.BookQueryDto;
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
public class BookReceiver {

    @Autowired
    private BookQueryService bookQueryService;

    @KafkaListener(id = "bookListen" ,topics = "sendBook")
    public void receive(@Payload String bookDtoString,
                        @Headers MessageHeaders headers) {
        ObjectMapper objectMapper=new ObjectMapper();
        BookQueryDto bookQueryDto=null;
        try {
            bookQueryDto = objectMapper.readValue(bookDtoString, BookQueryDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(bookQueryDto.getEvent().equals("book Added")) {
            bookQueryService.addBook(bookQueryDto);
        } else if (bookQueryDto.getEvent().equals("book Updated")) {
            bookQueryService.updateBookQuery(bookQueryDto);
        }else if(bookQueryDto.getEvent().equals("book Deleted")) {
            bookQueryService.deleteBookQuery(bookQueryDto);
        }

        //System.out.println("received message="+ sensorRecord.toString());
    }

}