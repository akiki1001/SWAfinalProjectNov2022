package BookService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryDto {

    private Long bookQueryNUmber;

    private String event;

    private BookDto bookDto;

}
