package bookQueryService.dto;

import bookQueryService.bookQueryDomain.Book;
import bookQueryService.bookQueryDomain.BookQuery;
import bookQueryService.bookQueryDomain.Review;

import java.util.stream.Collectors;

public class BookQueryAdapter {
    public static BookQuery getBookQuery(BookQueryDto bookQueryDto) {
        BookQuery bookQuery = new BookQuery(
                bookQueryDto.getBookQueryNUmber(),
                bookQueryDto.getEvent(),
                new Book(bookQueryDto.getBookDto().getIsbn(),bookQueryDto.getBookDto().getTitle(),bookQueryDto.getBookDto().getDescription()),
                bookQueryDto.getReviews().stream().map(n->new Review(n.getIsbn(),n.getRating(),n.getDescription(),n.getCustomerName()))
                        .collect(Collectors.toList())

        );
        return bookQuery;
    }

    public static BookQueryDto getBookQueryDto(BookQuery bookQuery) {
        BookQueryDto bookQueryDto = new BookQueryDto(
                bookQuery.getBookQueryNumber(),
                bookQuery.getEvent(),
                new BookDto(bookQuery.getBook().getIsbn(),bookQuery.getBook().getTitle(),bookQuery.getBook().getDescription()),
                bookQuery.getReviews().stream().map(n->new ReviewDto(n.getIsbn(),n.getRating(),n.getDescription(),n.getCustomerName()))
                        .collect(Collectors.toList())
                );
        return bookQueryDto;
    }
}
