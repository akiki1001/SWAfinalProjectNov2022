package borrowingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingDto {

    private long borrowingNUmber;

    private LocalDate borrowingDate;

    private BookDto bookDto;

    private CustomerDto customerDto;

}
