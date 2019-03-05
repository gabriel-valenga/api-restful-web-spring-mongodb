package com.cursonelioalves.javaspringweb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursonelioalves.javaspringweb.domain.User;
import com.cursonelioalves.javaspringweb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(String search) {
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}

}
