package social_network.dialogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DialogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DialogServiceApplication.class, args);
	}

}
