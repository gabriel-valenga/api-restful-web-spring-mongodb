package com.cursonelioalves.javaspringweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cursonelioalves.javaspringweb.domain.Post;
import com.cursonelioalves.javaspringweb.domain.User;
import com.cursonelioalves.javaspringweb.dto.UserDTO;
import com.cursonelioalves.javaspringweb.repository.PostRepository;
import com.cursonelioalves.javaspringweb.repository.UserRepository;
import com.cursonelioalves.javaspringweb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


	
}
