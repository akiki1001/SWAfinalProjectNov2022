package customerService.customerServiceWeb;

import customerService.dto.CustomerDto;
import customerService.customerServiceService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllBookQuery());
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        customerService.addBookQuery(customerDto);
        return ResponseEntity.ok().body(customerDto);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable BigInteger customerNumber){
        customerService.updateBookQuery(customerDto,customerNumber);
        return ResponseEntity.ok().body(customerDto);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@PathVariable BigInteger customerNumber){
        var customerDto= customerService.deleteBookQuery(customerNumber);
        return ResponseEntity.ok().body(customerDto);
    }
}
