package io.selflearning.contractconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContractConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractConsumerApplication.class, args);
	}
}
