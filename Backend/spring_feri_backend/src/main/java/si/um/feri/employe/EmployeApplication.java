package si.um.feri.employe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import si.um.feri.employe.dao.EmployeDataRepository;
import si.um.feri.employe.dao.EmployeRepository;
import java.util.logging.Logger;

@SpringBootApplication
public class EmployeApplication {

	private static final Logger log = Logger.getLogger(EmployeApplication.class.toString());

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeRepository daoProd, EmployeDataRepository daoMeas) {
		return args -> {
			log.info("Ready, Set, Go!");
			new EmployeRestServiceInit().populateTestDataIfNotPresent(daoProd,daoMeas);
		};
	}

}
