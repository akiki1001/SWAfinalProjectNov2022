package borrowingService.borrowingServiceWeb;

import borrowingService.dto.BorrowingDto;
import borrowingService.borrowingServiceService.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<BorrowingDto>> getAllBorrowing(){
        return ResponseEntity.ok().body(borrowingService.getAllBookQuery());
    }

    @PostMapping
    public ResponseEntity<?> createBorrowing(@RequestParam long customerNumber,@RequestParam long isbn){

        return ResponseEntity.ok().body(borrowingService.createBookQuery(customerNumber,isbn));
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

    public interface getCustomer{

    }
}
