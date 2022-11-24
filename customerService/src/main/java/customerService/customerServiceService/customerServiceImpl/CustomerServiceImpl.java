package customerService.customerServiceService.customerServiceImpl;

import customerService.customerServiceRepository.CustomerRepository;
import customerService.customerServiceService.CustomerService;
import customerService.cutomerIntegration.Sender;
import customerService.dto.CustomerAdapter;
import customerService.dto.CustomerDto;
import customerService.dto.CustomerEvent;
import net.projectmonkey.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private Sender sender;

    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream().map(n-> CustomerAdapter.getCustomerDto(n))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(long customerNumber) {


        return CustomerAdapter.getCustomerDto(customerRepository.findById(customerNumber).get());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        customerRepository.save(CustomerAdapter.getCustomer(customerDto));
        return customerDto;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, long customerNumber) {
        var customer= customerRepository.findById(customerNumber).get();
        if(customer==null){
            throw new NullPointerException("Customer not found");
        }
        customer.setName(customerDto.getName());
        customer.getContact().setEmail(customerDto.getContactDto().getEmail());
        customer.getContact().setPhone(customerDto.getContactDto().getPhone());
        customer.getAddress().setCity(customerDto.getAddressDto().getCity());
        customer.getAddress().setStreet(customerDto.getAddressDto().getStreet());
        customer.getAddress().setZip(customerDto.getAddressDto().getZip());

        customerRepository.save(customer);

        var customerEvent=new CustomerEvent(customerDto,"customer Updated");
        sender.send(customerEvent);

        return customerDto;
    }

    @Override
    public CustomerDto deleteCustomer(long customerNumber) {
        var customer= customerRepository.findById(customerNumber).get();
        if(customer==null){
            throw new NullPointerException("Customer not found ");
        }
        var customerDto=CustomerAdapter.getCustomerDto(customer);
        customerRepository.deleteById(customerNumber);
        return customerDto;
    }
}
