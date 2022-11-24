package BookService.dto;

import BookService.BookDomain.Book;

public class BookAdapter {
    public static Book getBook(BookDto bookDto) {
        Book customer = new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription()

                 );
        return customer;
    }

    public static BookDto getBookDto(Book book) {
        BookDto customerDto = new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getDescription()
        );
        return customerDto;
    }
}
