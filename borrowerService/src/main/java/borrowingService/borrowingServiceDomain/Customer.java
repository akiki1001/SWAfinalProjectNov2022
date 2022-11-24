package borrowingService.borrowingServiceDomain;

import borrowingService.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private long customerNumber;
    private String name;

    public Customer updateCustomer(Customer customer, CustomerDto customerDto){
        customer.setCustomerNumber(customerDto.getCustomerNumber());
        customer.setName(customerDto.getName());
        return customer;
    }


}