package com.spolight.appointment.appointment_booking.controller;

import com.spolight.appointment.appointment_booking.security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/system")
public class AppointmentController {

    @GetMapping("/api/health")
    public ResponseEntity<?> health(){
        return new ResponseEntity<>("System is healthy", HttpStatus.OK);
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal){
        return "if you see this, then you`re logged in as user "+principal.getEmail()
                +" user id "+principal.getUserId();
    }

}
