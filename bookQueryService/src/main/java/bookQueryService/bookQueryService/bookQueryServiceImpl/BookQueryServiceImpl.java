package bookQueryService.bookQueryService.bookQueryServiceImpl;

import bookQueryService.bookQueryDomain.Book;
import bookQueryService.bookQueryRepository.BookQueryRepository;
import bookQueryService.bookQueryService.BookQueryService;
import bookQueryService.dto.*;
import net.projectmonkey.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookQueryServiceImpl implements BookQueryService {
    @Autowired
    private BookQueryRepository bookQueryRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<BookQueryDto> getAllBookQuery() {
        return bookQueryRepository.findAll().stream().map(n-> BookQueryAdapter.getBookQueryDto(n))
                .collect(Collectors.toList());
    }

    @Override
    public void addReview(ReviewDto reviewDto) {
        var bookQuery=bookQueryRepository.findById(reviewDto.getIsbn()).get();
        if(bookQuery==null){
            throw new NullPointerException("book not found");
        }
        bookQuery.getReviews().add(ReviewAdapter.getReview(reviewDto));

        bookQueryRepository.save(bookQuery);
        System.out.println("New review is added");
    }

    @Override
    public void bookEvent(BookQueryDto bookQueryDto){
        bookQueryRepository.save(BookQueryAdapter.getBookQuery(bookQueryDto));

    }

    @Override
    public BookQueryDto updateBookEvent(BookQueryDto bookQueryDto) {
        var bookQuery= bookQueryRepository.findAllByBook_Isbn(bookQueryDto.getBookDto().getIsbn());
        if(bookQuery==null){
            throw new NullPointerException("Book Query not found");
        }

        bookQuery.stream().map(n->{
           var book= new Book(bookQueryDto.getBookDto().getIsbn(),
                    bookQueryDto.getBookDto().getTitle(),
                    bookQueryDto.getBookDto().getDescription());
            n.setBook(book);
            return n;
        }
        ).collect(Collectors.toList());
//        bookQuery.setEvent(bookQueryDto.getEvent());
//        bookQuery.setBook(new Book(bookQueryDto.getBookDto().getIsbn(),bookQueryDto.getBookDto().getTitle(),bookQueryDto.getBookDto().getDescription()));
          bookQueryRepository.save(BookQueryAdapter.getBookQuery(bookQueryDto));
        return bookQueryDto;
    }

//    @Override
//    public BookQueryDto deleteBookQuery(BookQueryDto bookQueryDto) {
//        bookEvent(bookQueryDto);
//        return bookQueryDto;
//
//
//
//
//    }
}
