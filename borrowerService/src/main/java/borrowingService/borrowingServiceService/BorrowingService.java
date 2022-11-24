package borrowingService.borrowingServiceService;

import borrowingService.dto.BookEvent;
import borrowingService.dto.BorrowingDto;
import borrowingService.dto.CustomerEvent;

import java.math.BigInteger;
import java.util.List;

public interface BorrowingService {

    public List<BorrowingDto> getAllBookQuery();
    //public void addBook(BookEvent bookEvent);
    public void updateBook(BookEvent bookEvent);
    public BorrowingDto updateBookQuery(BorrowingDto borrowingDto, long customerNumber);
    public BorrowingDto deleteBookQuery(long borrowingNumber);
    public void updateCustomer(CustomerEvent customerEvent);
    public BorrowingDto createBookQuery(long customerNumber,long isbn);

}
