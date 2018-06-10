package za.co.tamboer.tamboerblack11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TamboerBlack11Application {

	public static void main(String[] args) {
		SpringApplication.run(TamboerBlack11Application.class, args);
	}
}
