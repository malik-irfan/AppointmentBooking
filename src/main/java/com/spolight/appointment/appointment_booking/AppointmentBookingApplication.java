package com.spolight.appointment.appointment_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude = { SecurityAutoConfiguration.class })
public class AppointmentBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentBookingApplication.class, args);
	}

}
