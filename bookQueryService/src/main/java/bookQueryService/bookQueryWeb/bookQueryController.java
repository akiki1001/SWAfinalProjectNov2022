package bookQueryService.bookQueryWeb;

import bookQueryService.dto.BookQueryDto;
import bookQueryService.bookQueryService.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view/book")
public class bookQueryController {
    @Autowired
    private BookQueryService bookQueryService;

    @GetMapping
    public ResponseEntity<List<BookQueryDto>> getAllCustomers(){
        return ResponseEntity.ok().body(bookQueryService.getAllBookQuery());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookQueryDto bookQueryDto){
        bookQueryService.bookEvent(bookQueryDto);
        return ResponseEntity.ok().body(bookQueryDto);
    }

//    @PutMapping
//    public ResponseEntity<?> updateCustomer(@RequestBody BookQueryDto bookQueryDto, @PathVariable Long bookQueryNumber){
//        bookQueryService.updateBookQuery(bookQueryDto,bookQueryNumber);
//        return ResponseEntity.ok().body(bookQueryDto);
//    }
//    @DeleteMapping
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long bookQueryNumber){
//        var bookQueryDto= bookQueryService.deleteBookQuery(bookQueryNumber);
//        return ResponseEntity.ok().body(bookQueryDto);
//    }
}
