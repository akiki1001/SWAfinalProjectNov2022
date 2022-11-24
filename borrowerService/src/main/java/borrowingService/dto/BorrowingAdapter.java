package borrowingService.dto;

import borrowingService.borrowingServiceDomain.Book;
import borrowingService.borrowingServiceDomain.Customer;
import borrowingService.borrowingServiceDomain.Borrowing;

public class BorrowingAdapter {
    public static Borrowing getBorrowing(BorrowingDto borrowingDto) {
        Borrowing borrowing = new Borrowing(
                borrowingDto.getBorrowingNUmber(),
                //borrowingDto.getBorrowingDate(),
                new Book(borrowingDto.getBookDto().getIsbn(), borrowingDto.getBookDto().getTitle(), borrowingDto.getBookDto().getDescription()),
                new Customer(borrowingDto.getCustomerDto().getCustomerNumber(), borrowingDto.getCustomerDto().getName())
        );
        return borrowing;
    }

    public static BorrowingDto getBorrowingDto(Borrowing borrowing) {
        BorrowingDto borrowingDto = new BorrowingDto(
                borrowing.getBorrowerNumber(),
                //borrowing.getBorrowingDate(),
               new BookDto(borrowing.getBook().getIsbn(), borrowing.getBook().getTitle(), borrowing.getBook().getDescription()),
                new CustomerDto(borrowing.getCustomer().getCustomerNumber(), borrowing.getCustomer().getName())

        );
        return borrowingDto;
    }
}
