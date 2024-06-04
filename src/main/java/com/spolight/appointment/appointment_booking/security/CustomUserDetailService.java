package com.spolight.appointment.appointment_booking.security;

import com.spolight.appointment.appointment_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.findByEmail(username);

        return UserPrincipal.builder()
                .userId(user.get().getId())
                .email(user.get().getEmail())
                .authorities(List.of(new SimpleGrantedAuthority(user.get().getRole())))
                .password(user.get().getPassword())
                .build();
    }
}
