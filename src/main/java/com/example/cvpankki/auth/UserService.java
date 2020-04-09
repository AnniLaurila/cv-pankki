package com.example.cvpankki.auth;

import com.example.cvpankki.domain.User;

public interface UserService {

	public void save(User user);

	public User findByUsername(String username);

}
