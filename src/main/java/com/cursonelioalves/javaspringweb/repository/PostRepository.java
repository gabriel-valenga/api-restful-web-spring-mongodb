package com.cursonelioalves.javaspringweb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursonelioalves.javaspringweb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}