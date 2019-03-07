package com.cursonelioalves.javaspringweb.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursonelioalves.javaspringweb.domain.Post;
import com.cursonelioalves.javaspringweb.domain.User;
import com.cursonelioalves.javaspringweb.dto.AuthorDTO;
import com.cursonelioalves.javaspringweb.repository.PostRepository;
import com.cursonelioalves.javaspringweb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired 
	UserRepository userRepository;	
	
	@Autowired 
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu vagem!", "Vou viajar para São Paulo", new AuthorDTO(bob));
		Post post2 = new Post(null, sdf.parse("08/06/2018"), "Bom dia!", "Bom dia a todos!", new AuthorDTO(alex));
				
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
