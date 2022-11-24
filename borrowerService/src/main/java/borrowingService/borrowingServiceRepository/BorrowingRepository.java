package borrowingService.borrowingServiceRepository;

import borrowingService.borrowingServiceDomain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing, Long> {
    List<Borrowing> findAllByBook_Isbn(Long isbn);
    List<Borrowing> findAllByCustomer_CustomerNumber(Long customerNumber);
}
