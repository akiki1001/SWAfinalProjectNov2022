package bookQueryService.dto;

import bookQueryService.bookQueryDomain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryDto {

    private long bookQueryNUmber;

    private String event;


    private BookDto bookDto;

    private List<ReviewDto> reviews;

}
