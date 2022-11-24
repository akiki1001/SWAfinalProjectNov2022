package borrowingService.borrowingServiceDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Document
public class Borrowing {
    @Id
    private long borrowerNumber;

   // private LocalDate borrowingDate;

    private Book book;

    private Customer customer;

    public Borrowing(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
    }

    public Borrowing(long borrowerNumber, Book book, Customer customer) {
        this.borrowerNumber = borrowerNumber;
        this.book = book;
        this.customer = customer;
    }

    public Borrowing() {

    }
}
