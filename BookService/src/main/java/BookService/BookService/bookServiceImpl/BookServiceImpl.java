package BookService.BookService.bookServiceImpl;

import BookService.BookIntegration.SendToBorrowing;
import BookService.BookIntegration.SenderToBookQuery;
import BookService.BookRepository.BookRepository;
import BookService.BookService.BookService;
import BookService.dto.BookAdapter;
import BookService.dto.BookDto;
import BookService.dto.BookEvent;
import BookService.dto.BookQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SenderToBookQuery senderToBookQuery;

    @Autowired
    private SendToBorrowing sendToBorrowing;



    @Override
    public List<BookDto> getAllBook() {
        return bookRepository.findAll().stream().map(n-> BookAdapter.getBookDto(n))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBook(long isbn) {
        return BookAdapter.getBookDto(bookRepository.findById(isbn).get());
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        var book=BookAdapter.getBook(bookDto);
        bookRepository.save(book);
        var bookQueryDto=new BookQueryDto(book.getIsbn(),"book Added",bookDto);
        senderToBookQuery.send(bookQueryDto);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long bookNumber) {
        var book= bookRepository.findById(bookNumber).get();
        if(book==null){
            throw new NullPointerException("Book not found");
        }
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        bookRepository.save(book);
        var bookQueryDto=new BookQueryDto(book.getIsbn(),"book Updated",bookDto);
        senderToBookQuery.send(bookQueryDto);
        var bookEvent=new BookEvent(bookDto,"book Updated");
        sendToBorrowing.send(bookEvent);


        return bookDto;
    }

    @Override
    public BookDto deleteBook(Long bookNumber) {
        var book= bookRepository.findById(bookNumber).get();
        if(book==null){
            throw new NullPointerException("Book not found ");
        }
        var bookDto=BookAdapter.getBookDto(book);
        bookRepository.deleteById(bookNumber);
        var bookQueryDto=new BookQueryDto(book.getIsbn(),"book Deleted",bookDto);
        senderToBookQuery.send(bookQueryDto);
        return bookDto;
    }
}
