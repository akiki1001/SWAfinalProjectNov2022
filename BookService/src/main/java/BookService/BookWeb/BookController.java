package BookService.BookWeb;

import BookService.BookService.BookService;
import BookService.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllCustomers(){
        return ResponseEntity.ok().body(bookService.getAllBook());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
        return ResponseEntity.ok().body(bookDto);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto, @PathVariable Long bookNumber){
        bookService.updateBook(bookDto,bookNumber);
        return ResponseEntity.ok().body(bookDto);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBook(@PathVariable Long bookNumber){
        var bookDto= bookService.deleteBook(bookNumber);
        return ResponseEntity.ok().body(bookDto);
    }
}
