package hd.ahmed.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Application started");
		log.info("ok");
	}
//	@Bean
//	CommandLineRunner runner(RunRepositoryInMemory runRepositoryInMemory) {
//		return args -> {
//			Run run=new Run(1,"First run", LocalDateTime.now(), LocalDateTime.now().plusHours(1),5,Location.OUTDOOR);
//			runRepositoryInMemory.create(run);
//		};
//	}
}
