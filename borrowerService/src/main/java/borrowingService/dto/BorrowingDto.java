package borrowingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class BorrowingDto {

    private long borrowingNUmber;

    //private LocalDate borrowingDate;

    private BookDto bookDto;

    private CustomerDto customerDto;
    public BorrowingDto() {
    }

    public BorrowingDto(long borrowingNUmber, BookDto bookDto, CustomerDto customerDto) {
        this.borrowingNUmber = borrowingNUmber;
        this.bookDto = bookDto;
        this.customerDto = customerDto;
    }
}
