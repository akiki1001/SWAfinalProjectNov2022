package ReviewService;

import net.projectmonkey.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ReviewServiceApplication {


	@Bean
	ModelMapper modelMapper(){ return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}

}
