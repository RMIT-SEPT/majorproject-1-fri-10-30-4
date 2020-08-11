package sampleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model.user")
@EnableJpaRepositories("dao")
public class SampleSpringApp {
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringApp.class, args);
	}
}
