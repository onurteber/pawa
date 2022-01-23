package com.pawa.authservice.controller;

import com.pawa.authservice.dto.LoginDTO;
import com.pawa.authservice.dto.LoginResponseDTO;
import com.pawa.authservice.dto.UserDto;
import com.pawa.authservice.service.UserService;
import com.pawa.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthController {


	@Autowired
	private UserService userService;

	@PostMapping("/auth/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {

		final LoginResponseDTO loginResponseDTO = userService.login(loginDTO);

		return new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/auth/register")
	public ResponseEntity<?> register(@RequestBody UserDto user){
		return ResponseEntity.ok(userService.save(user));
	}

}
