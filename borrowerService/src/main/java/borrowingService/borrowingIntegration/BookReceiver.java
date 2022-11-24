package borrowingService.borrowingIntegration;


import borrowingService.borrowingServiceService.BorrowingService;
import borrowingService.dto.BookDto;
import borrowingService.dto.BookEvent;
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
    private BorrowingService borrowingService;

    @KafkaListener(id = "bookListen2" ,topics = "updateBookInBorrowing")
    public void receive(@Payload String bookEventString,
                        @Headers MessageHeaders headers) {
        ObjectMapper objectMapper=new ObjectMapper();
        BookEvent bookEvent=null;
        try {
            bookEvent = objectMapper.readValue(bookEventString, BookEvent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        if(bookEvent.getEvent().equals("book Added")) {
//            borrowingService.addBook(bookEvent);
//        } else if (bookEvent.getEvent().equals("book Updated")) {
            borrowingService.updateBook(bookEvent);
//        }else if(bookEvent.getEvent().equals("book Deleted")) {
//            borrowingService.deleteBook(bookEvent);
//        }

        //System.out.println("received message="+ sensorRecord.toString());
    }

}