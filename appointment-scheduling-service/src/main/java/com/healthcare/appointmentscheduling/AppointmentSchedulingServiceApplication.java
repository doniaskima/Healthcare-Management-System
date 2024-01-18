package com.healthcare.appointmentscheduling;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class AppointmentSchedulingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulingServiceApplication.class, args);
	}

}
