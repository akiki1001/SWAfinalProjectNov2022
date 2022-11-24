package bookQueryService.bookQueryDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookQuery {
    @Id
    private long bookQueryNumber;

    private String event;
    private Book book;
    private List<Review> reviews;

}
