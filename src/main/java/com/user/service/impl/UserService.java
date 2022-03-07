package com.user.service.impl;

import com.user.service.dto.UserDto;

public interface UserService {

	public String login(String emailId, String password);

	public String register(UserDto userDto);

	public String logout();

	public String resetPswd(String emailId, String oldPswd, String newPswd);
}
