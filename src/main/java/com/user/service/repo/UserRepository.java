package com.user.service.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.service.document.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, Long>{

	Optional<UserDocument> findByEmailIdAndPassword(String emailId, String password);

}