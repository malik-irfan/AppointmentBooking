package com.spolight.appointment.appointment_booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
}
