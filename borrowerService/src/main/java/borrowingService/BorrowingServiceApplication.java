package borrowingService;

import net.projectmonkey.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BorrowingServiceApplication {


	@Bean
	ModelMapper modelMapper(){ return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(BorrowingServiceApplication.class, args);
	}

}
