package customerService.customerServiceRepository;

import customerService.customerServiceDomain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
