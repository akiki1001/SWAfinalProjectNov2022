package customerService.customerServiceDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
    @Id
    private BigInteger customerNumber;

    private String name;

    private Contact contact;

    private Address address;

}
