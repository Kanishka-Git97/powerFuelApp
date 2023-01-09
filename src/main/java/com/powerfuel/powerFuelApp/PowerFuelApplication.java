package com.powerfuel.powerFuelApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PowerFuelApplication {

	public static void main(String[] args) {

		SpringApplication.run(PowerFuelApplication.class, args);
		while (true) {
			Date date = new Date();
			//Implement Fuel Refilling Methods and Token Expired Function
			
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


