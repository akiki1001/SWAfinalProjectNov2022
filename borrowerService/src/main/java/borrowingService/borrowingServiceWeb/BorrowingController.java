package borrowingService.borrowingServiceWeb;

import borrowingService.dto.BookDto;
import borrowingService.dto.BorrowingDto;
import borrowingService.borrowingServiceService.BorrowingService;
import borrowingService.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @Autowired
    GetCustomer getCustomer;
    @Autowired
    GetBook getBook;

    @GetMapping
    public ResponseEntity<List<BorrowingDto>> getAllBorrowing(){
        return ResponseEntity.ok().body(borrowingService.getAllBookQuery());
    }

    @PostMapping
    public ResponseEntity<?> createBorrowing(@RequestParam long customerNumber,@RequestParam long isbn){
        BookDto bookDto =getBook.getBook(isbn);
            CustomerDto customerDto=getCustomer.getCustomers(customerNumber);

        return ResponseEntity.ok().body(borrowingService.createBookQuery(bookDto,customerDto));
    }

    @PutMapping
    public ResponseEntity<?> updateBorrowing(@RequestBody BorrowingDto borrowingDto, @PathVariable long customerNumber){
        borrowingService.updateBookQuery(borrowingDto,customerNumber);
        return ResponseEntity.ok().body(borrowingDto);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBorrowing(@PathVariable long borrowingNumber){
        var customerDto= borrowingService.deleteBookQuery(borrowingNumber);
        return ResponseEntity.ok().body(customerDto);
    }

    @FeignClient("CustomerService")
    public interface GetCustomer{
        @RequestMapping("/customers/{id}")
        public CustomerDto getCustomers(@PathVariable("id") long customerNumber);
    }

    @FeignClient("BookService")
    public interface GetBook{
        @GetMapping("/books/{id}")
        public BookDto getBook(@PathVariable("id") long isbn);
    }
}
