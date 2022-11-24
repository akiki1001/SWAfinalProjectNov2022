package bookQueryService.bookQueryService;

import bookQueryService.dto.BookQueryDto;
import bookQueryService.dto.ReviewDto;

import java.util.List;

public interface BookQueryService {

    public List<BookQueryDto> getAllBookQuery();

    public void addReview(ReviewDto reviewDto);
    public void bookEvent(BookQueryDto bookQueryDto);
    public BookQueryDto updateBookEvent(BookQueryDto bookQueryDto);
    //public BookQueryDto deleteBookQuery(BookQueryDto bookQueryDto);

}
