package com.games.ecommerce.gamespayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class GamesPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesPaymentApplication.class, args);
	}

}
