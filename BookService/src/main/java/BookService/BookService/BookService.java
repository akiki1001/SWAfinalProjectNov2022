package BookService.BookService;

import BookService.dto.BookDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookService {

    public List<BookDto> getAllBook();
    public BookDto getBook(long isbn);
    public BookDto addBook(BookDto bookDto);
    public BookDto updateBook(BookDto bookDto, Long bookNumber);
    public BookDto deleteBook(Long bookNumber);

}
