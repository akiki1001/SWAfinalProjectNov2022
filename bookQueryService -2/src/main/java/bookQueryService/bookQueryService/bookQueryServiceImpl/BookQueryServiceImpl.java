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
        System.out.println("the new review is added");
    }

    @Override
    public void addBook(BookQueryDto bookQueryDto){
      // var booQueryDto = BookQueryAdapter.getBookQuery(bookQueryDto);
        bookQueryRepository.save(BookQueryAdapter.getBookQuery(bookQueryDto));

    }

    @Override
    public BookQueryDto updateBookQuery(BookQueryDto bookQueryDto) {
        var bookQuery= bookQueryRepository.findById(bookQueryDto.getBookQueryNUmber()).get();
        if(bookQuery==null){
            throw new NullPointerException("Book Query not found");
        }
        bookQuery.setEvent(bookQueryDto.getEvent());
        bookQuery.setBook(new Book(bookQueryDto.getBookDto().getIsbn(),bookQueryDto.getBookDto().getTitle(),bookQueryDto.getBookDto().getDescription()));
        bookQueryRepository.save(bookQuery);
        return bookQueryDto;
    }

    @Override
    public BookQueryDto deleteBookQuery(BookQueryDto bookQueryDto) {
        var bookQuery= bookQueryRepository.findById(bookQueryDto.getBookQueryNUmber()).get();
        if(bookQuery==null){
            throw new NullPointerException("Book Query not found ");
        }
        bookQueryRepository.deleteById(bookQuery.getBookQueryNumber());
        return bookQueryDto;
    }
}
