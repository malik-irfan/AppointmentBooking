package com.spolight.appointment.appointment_booking.service;

import com.spolight.appointment.appointment_booking.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String EXISTING_EMAIL = "test@appointment.com";

    public Optional<UserEntity> findByEmail(String email){
        // TODO: Move this to a database
        if (!EXISTING_EMAIL.equalsIgnoreCase(email)) return Optional.empty();

        var user = new UserEntity();
        user.setId(1L);
        user.setEmail(EXISTING_EMAIL);
        user.setPassword("$2a$12$cHixzDKXybd./aJkzVQsmO0PFKsTBm8gV/nbX.oCqpL/QLR7elcl2"); // test
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("My nice admin");
        return Optional.of(user);
    }
}
