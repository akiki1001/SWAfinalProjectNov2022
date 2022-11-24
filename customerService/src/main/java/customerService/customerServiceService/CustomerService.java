package customerService.customerServiceService;

import customerService.dto.CustomerDto;

import java.math.BigInteger;
import java.util.List;

public interface CustomerService {

    public List<CustomerDto> getAllBookQuery();
    public CustomerDto addBookQuery(CustomerDto customerDto);
    public CustomerDto updateBookQuery(CustomerDto customerDto, BigInteger customerNumber);
    public CustomerDto deleteBookQuery(BigInteger customerNumber);

}
