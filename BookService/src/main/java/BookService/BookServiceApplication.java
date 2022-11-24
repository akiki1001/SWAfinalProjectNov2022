package BookService;

import net.projectmonkey.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/books")
public class BookServiceApplication {


	@Bean
	ModelMapper modelMapper(){ return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
