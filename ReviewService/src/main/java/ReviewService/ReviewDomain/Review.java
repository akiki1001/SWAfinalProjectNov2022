package ReviewService.ReviewDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    private Long isbn;
    private int rating;
    private String description;
    private String customerName;


}
