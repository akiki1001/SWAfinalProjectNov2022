package bookQueryService.bookQueryService;

import bookQueryService.dto.BookDto;
import bookQueryService.dto.BookQueryDto;
import bookQueryService.dto.ReviewDto;

import java.util.List;

public interface BookQueryService {

    public List<BookQueryDto> getAllBookQuery();

    public void addReview(ReviewDto reviewDto);
    public void addBook(BookQueryDto bookQueryDto);
    public BookQueryDto updateBookQuery(BookQueryDto bookQueryDto);
    public BookQueryDto deleteBookQuery(BookQueryDto bookQueryDto);

}
