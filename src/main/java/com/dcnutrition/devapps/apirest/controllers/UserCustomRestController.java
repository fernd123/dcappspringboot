package com.dcnutrition.devapps.apirest.controllers;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcnutrition.devapps.apirest.models.entity.UserCustom;
import com.dcnutrition.devapps.apirest.models.services.IUserCustomService;

@RestController
public class UserCustomRestController {

	private IUserCustomService usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserCustomRestController(IUserCustomService usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/users/")
	public void saveUsuario(@RequestBody UserCustom user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	}

	@GetMapping("/users/")
	public List<UserCustom> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/users/{username}")
	public UserCustom getUsuario(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
}
