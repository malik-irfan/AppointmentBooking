package com.spolight.appointment.appointment_booking.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client {

    private long id;
    private String clientName;
    private String contactMobile;
    private String contactMail;
}
