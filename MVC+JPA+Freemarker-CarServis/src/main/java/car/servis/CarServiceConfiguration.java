package car.servis;

import car.servis.servis.AplicationIssuesService;
import car.servis.servis.IssuesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarServiceConfiguration {
	
	@Bean
	public IssuesService issueService() {
		return new AplicationIssuesService();
	}

}
