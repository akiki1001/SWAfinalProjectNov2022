package customerService.customerServiceWeb;

import customerService.dto.CustomerDto;
import customerService.customerServiceService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }
    @GetMapping("/{id}")
    public CustomerDto getCustomers(@PathVariable("id") long customerNumber){
        return customerService.getCustomer(customerNumber);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return ResponseEntity.ok().body(customerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("id") long customerNumber){
        customerService.updateCustomer(customerDto,customerNumber);
        return ResponseEntity.ok().body(customerDto);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerNumber){
        var customerDto= customerService.deleteCustomer(customerNumber);
        return ResponseEntity.ok().body(customerDto);
    }
}
