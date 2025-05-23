package com.yash.internet_banking_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class InternetBankingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingConfigServerApplication.class, args);
	}

}
