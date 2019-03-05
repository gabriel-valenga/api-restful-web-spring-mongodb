package com.cursonelioalves.javaspringweb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursonelioalves.javaspringweb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
