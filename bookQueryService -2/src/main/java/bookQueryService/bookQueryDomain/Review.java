package bookQueryService.bookQueryDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private long isbn;
    private int rating;
    private String description;
    private String customerName;

}
