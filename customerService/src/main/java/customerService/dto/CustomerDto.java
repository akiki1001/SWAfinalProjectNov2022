package customerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private BigInteger customerNUmber;

    private String name;

    private ContactDto contactDto;

    private AddressDto addressDto;

}
