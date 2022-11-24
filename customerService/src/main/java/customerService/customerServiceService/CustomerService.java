package customerService.customerServiceService;

import customerService.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    public List<CustomerDto> getAllCustomer();
    public CustomerDto getCustomer(long customerNumber);

    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(CustomerDto customerDto, long customerNumber);
    public CustomerDto deleteCustomer(long customerNumber);

}
