package com.dsa.trade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 
 * @author Bharat Patel
 *
 */
@EnableScheduling
@SpringBootApplication
public class TradeStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeStoreAppApplication.class, args);
	}

}
