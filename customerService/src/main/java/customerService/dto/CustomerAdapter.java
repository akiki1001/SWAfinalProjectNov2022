package customerService.dto;

import customerService.customerServiceDomain.Contact;
import customerService.customerServiceDomain.Address;
import customerService.customerServiceDomain.Customer;

public class CustomerAdapter {
    public static Customer getCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerDto.getCustomerNUmber(),
                customerDto.getName(),
                new Contact(customerDto.getContactDto().getEmail(),customerDto.getContactDto().getPhone()),
                new Address(customerDto.getAddressDto().getCity(),customerDto.getAddressDto().getStreet(),customerDto.getAddressDto().getZip())
        );
        return customer;
    }

    public static CustomerDto getCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerNumber(),
                customer.getName(),
               new ContactDto(customer.getContact().getEmail(),customer.getContact().getPhone()),
                new AddressDto(customer.getAddress().getCity(),customer.getAddress().getStreet(),customer.getAddress().getZip())

        );
        return customerDto;
    }
}
