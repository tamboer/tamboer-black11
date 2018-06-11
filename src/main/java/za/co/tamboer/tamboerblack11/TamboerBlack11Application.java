package za.co.tamboer.tamboerblack11;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import za.co.tamboer.tamboerblack11.player.Player;
import za.co.tamboer.tamboerblack11.player.persistence.PlayerRepository;

import java.util.stream.Stream;

//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TamboerBlack11Application {

	public static void main(String[] args) {
		SpringApplication.run(TamboerBlack11Application.class, args);
	}


	@Bean
	ApplicationRunner init(PlayerRepository	repository) {
		return args -> {
			Stream.of(
					"Bob Nelson",
					"Joe Martin",
					"Alf Smith",
					"Jan Olaf"
			).forEach(name -> {
				Player player = new Player();
				player.setUsername(name.substring(0,3));
				player.setEmail(name.substring(0,3) + "@example.com");
				player.setName(name);
				player.setAlias(name.substring(0,3));
				player.setGender("male");
				player.setAge(55);
				repository.save(player);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
