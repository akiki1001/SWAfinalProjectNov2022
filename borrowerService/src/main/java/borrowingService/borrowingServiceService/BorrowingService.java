package borrowingService.borrowingServiceService;

import borrowingService.dto.*;

import java.math.BigInteger;
import java.util.List;

public interface BorrowingService {

    public List<BorrowingDto> getAllBookQuery();
    //public void addBook(BookEvent bookEvent);
    public void updateBook(BookEvent bookEvent);
    public BorrowingDto updateBookQuery(BorrowingDto borrowingDto, long customerNumber);
    public BorrowingDto deleteBookQuery(long borrowingNumber);
    public void updateCustomer(CustomerEvent customerEvent);
    public BorrowingDto createBookQuery(BookDto bookDto, CustomerDto customerDto);

}
