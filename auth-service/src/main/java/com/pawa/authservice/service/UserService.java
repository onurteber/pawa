package com.pawa.authservice.service;

import com.pawa.authservice.domain.User;
import com.pawa.authservice.dto.LoginDTO;
import com.pawa.authservice.dto.LoginResponseDTO;
import com.pawa.authservice.dto.UserDto;
import com.pawa.authservice.exception.BadCredentialsException;
import com.pawa.authservice.exception.UsernameExistException;
import com.pawa.authservice.reporsitory.UserRepository;
import com.pawa.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder bcryptEncoder;

    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder bcryptEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bcryptEncoder = bcryptEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        try {
            User usersPojo = userRepository.findByUsername(username);
            return new org.springframework.security.core.userdetails.User(usersPojo.getUsername(), usersPojo.getPassword(),
                    new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }

    public LoginResponseDTO login(final LoginDTO loginDTO) {
        final UserDetails userDetails = loadUserByUsername(loginDTO.getUsername());
        if(bcryptEncoder.matches(loginDTO.getPassword(), userDetails.getPassword())) {
            return new LoginResponseDTO(jwtUtil.generateToken(userDetails.getUsername()), userDetails.getUsername());
        }
        throw new BadCredentialsException();
    }

    public Object save(UserDto user) {
        checkUser(user.getUsername());
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }

    private void checkUser(String username) {
        if(userRepository.findByUsername(username) != null) {
            throw new UsernameExistException();
        }
    }
}
