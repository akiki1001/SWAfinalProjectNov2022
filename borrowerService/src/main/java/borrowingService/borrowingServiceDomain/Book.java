package borrowingService.borrowingServiceDomain;

import borrowingService.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long isbn;
    private String title;
    private String description;


    public Book updateBook(Book book, BookDto bookDto){
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setDescription(book.getDescription());
        return book;
    }

}

