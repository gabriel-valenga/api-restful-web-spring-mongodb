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
import com.cursonelioalves.javaspringweb.dto.CommentDTO;
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo", new AuthorDTO(bob));
		Post post2 = new Post(null, sdf.parse("08/06/2018"), "Bom dia!", "Bom dia a todos!", new AuthorDTO(alex));
				
		CommentDTO c1 = new CommentDTO("Boa Viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Traga presentes!", sdf.parse("21/03/2018"), new AuthorDTO(maria));
		CommentDTO c3 = new CommentDTO("Bom dia!", sdf.parse("08/06/2018"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		alex.getPosts().addAll(Arrays.asList(post2));
		bob.getPosts().addAll(Arrays.asList(post1));
		
		userRepository.saveAll(Arrays.asList(alex, bob));

	}

}
