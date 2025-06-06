package java_spring_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("java_spring_challenge.domain.model")  // ← Add this
public class SpringChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}
}
