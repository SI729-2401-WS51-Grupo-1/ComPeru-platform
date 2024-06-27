package pe.edu.upc.comperu_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ComperuPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComperuPlatformApplication.class, args);
	}

}
