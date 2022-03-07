package com.user.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.service.document.UserDocument;
import com.user.service.dto.UserDto;
import com.user.service.repo.UserRepository;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public String login(String emailId, String password) {
		Optional<UserDocument> validLogin= userRepo.findByEmailIdAndPassword(emailId, password);
		if(validLogin.isPresent()) {
			return "User login successful";
		}
		else return "User Credentials are not valid";
	}

	@Override
	public String register(UserDto userDto) {
		Optional<UserDocument> userAlreadyPresent= userRepo.findByEmailIdAndPassword(userDto.getEmailId(), userDto.getPassword());
		if(!userAlreadyPresent.isPresent()) {
			UserDocument userDoc=new UserDocument();
			userDoc.setUserId(sequenceGeneratorService.generateSequence(UserDocument.SEQUENCE_NAME));
			BeanUtils.copyProperties(userDto, userDoc);
			userRepo.save(userDoc);
			return "User registeration successful";
		}
		else return "User already have account";
	}

	@Override
	public String logout() {
		
		return "User successfully logged out";
	}

	@Override
	public String resetPswd(String emailId,String oldPswd, String newPswd) {
		Optional<UserDocument> userAlreadyPresent= userRepo.findByEmailIdAndPassword(emailId, oldPswd);
		if(userAlreadyPresent.isPresent()) {
			userAlreadyPresent.get().setPassword(newPswd);
			userRepo.save(userAlreadyPresent.get());
			return "User Password successfully changed";
		}
		else
		return "User account not found";
	}

}
