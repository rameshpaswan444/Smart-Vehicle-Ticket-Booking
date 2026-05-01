package com.vehicle.ticketbooking.Jwt;

import com.vehicle.ticketbooking.Dto.AuthResponseDto;
import com.vehicle.ticketbooking.Dto.LoginRequestDto;
import com.vehicle.ticketbooking.Dto.RegisterRequestDto;
import com.vehicle.ticketbooking.Entity.User;
import com.vehicle.ticketbooking.Enum.Role;
import com.vehicle.ticketbooking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public String register(RegisterRequestDto request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponseDto(token);
    }
}
