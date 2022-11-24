package bookQueryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDto {

    private Long isbn;
    private int rating;
    private String description;
    private String customerName;
}