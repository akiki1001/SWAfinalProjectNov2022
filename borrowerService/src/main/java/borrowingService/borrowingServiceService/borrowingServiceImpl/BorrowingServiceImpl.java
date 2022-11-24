package borrowingService.borrowingServiceService.borrowingServiceImpl;

import borrowingService.borrowingServiceDomain.Book;
import borrowingService.borrowingServiceDomain.Customer;
import borrowingService.borrowingServiceRepository.BorrowingRepository;
import borrowingService.borrowingServiceService.BorrowingService;
import borrowingService.dto.*;
import net.projectmonkey.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<BorrowingDto> getAllBookQuery() {
        return borrowingRepository.findAll().stream().map(n-> BorrowingAdapter.getBorrowingDto(n))
                .collect(Collectors.toList());
    }

//    @Override
//    public void addBook(BookEvent bookEvent) {
//        var bookDto=bookEvent.getBookDto();
//        var borrowing=borrowingRepository.findAllByBook_Isbn(bookDto.getIsbn());
//        borrowing.setBook(BookAdapter.getBook(bookDto));
//        borrowingRepository.save(borrowing);
//
//    }
    @Override
    public void updateBook(BookEvent bookEvent) {
        var borrowing= borrowingRepository.findAllByBook_Isbn(bookEvent.getBookDto().getIsbn());
        if(borrowing==null){
            throw new NullPointerException("Borrowing not found");
        }

        borrowing.stream().map(n->{
                    var book= new Book(bookEvent.getBookDto().getIsbn(),
                            bookEvent.getBookDto().getTitle(),
                            bookEvent.getBookDto().getDescription());
                    n.setBook(book);
                    return n;
                }
        ).collect(Collectors.toList());


        borrowing.stream().map(n->borrowingRepository.save(n));


    }

    @Override
    public void updateCustomer(CustomerEvent customerEvent) {
        var borrowing= borrowingRepository.findAllByCustomer_CustomerNumber(customerEvent.getCustomerDto().getCustomerNumber());
        if(borrowing==null){
            throw new NullPointerException("Borrowing not found");
        }

        borrowing.stream().map(n->{
                    var customer= new Customer(customerEvent.getCustomerDto().getCustomerNumber(),
                            customerEvent.getCustomerDto().getName());
                    n.setCustomer(customer);
                    return n;
                }
        ).collect(Collectors.toList());

        borrowing.stream().map(n->borrowingRepository.save(n));



    }

    @Override
    public BorrowingDto updateBookQuery(BorrowingDto borrowingDto, long borrowingNumber) {
        var borrowing= borrowingRepository.findById(borrowingNumber).get();
        if(borrowing==null){
            throw new NullPointerException("Borrowing not found");
        }
        //here I will try to update DDD
       borrowing.setBorrowingDate(borrowingDto.getBorrowingDate());
        borrowing.setBook(new Book().updateBook(borrowing.getBook(),borrowingDto.getBookDto()));
        borrowing.setCustomer(new Customer().updateCustomer(borrowing.getCustomer(),borrowingDto.getCustomerDto()));

        borrowingRepository.save(borrowing);

        return borrowingDto;
    }

    @Override
    public BorrowingDto deleteBookQuery(long customerNumber) {
        var customer= borrowingRepository.findById(customerNumber).get();
        if(customer==null){
            throw new NullPointerException("Borrowing not found ");
        }
        var customerDto= BorrowingAdapter.getBorrowingDto(customer);
        borrowingRepository.deleteById(customerNumber);
        return customerDto;
    }

    //@Override
//    public void deleteBook(BookEvent bookEvent) {
//        var borrowing= borrowingRepository.findById(bookEvent.getBookDto().getIsbn()).get();
//        if(borrowing==null){
//            throw new NullPointerException("Customer not found");
//        }
//
//        borrowing.setBook(new Book().updateBook(borrowing.getBook(),bookEvent.getBookDto()));
//
//
//        borrowingRepository.save(borrowing);
//    }

    @Override
    public BorrowingDto createBookQuery(long customerNumber, long isbn) {
        return null;

        //should work create
    }
}
