package com.connect.socialMedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.connect.socialMedia.daos.UserDao;
import com.connect.socialMedia.entities.*;
import com.connect.socialMedia.utility.*;


@Transactional
@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findUserFromdbByEmail(String email) {
		User user = userDao.findByEmail(email);
		return user;
	}

	public User findUserFromdbById(int userId) {
		User user = userDao.findById(userId);
		return user;
	}

	public User findUserByEmailAndPassword(Credentials cred) {
		User dbUser = userDao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if (dbUser != null && passwordEncoder.matches(rawPassword, dbUser.getPassword())) {
			User result = dbUser;
//			result.setPassword("********");
			return result;
		}
		return null;
	}

	public List<User> findAllUsers() {
		List<User> userList = userDao.findAll();
		return userList;
	}

	public User saveUser(User user) {
		User newUser = findUserFromdbByEmail(user.getEmail());
		if (newUser != null) {
			return null;
		}
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);

		user.setPassword(encPassword);
//		User user1 = user;
		try {
			user = userDao.save(user);
			return user;

		} catch (DataIntegrityViolationException e) {

		}

		return user;

	}

//	public void updateUser(String userName, long mobileNo,String password,int id);
	public void updateUser(String userName, long mobileNo, String password, int id) {
		userDao.updateUser(userName, mobileNo, password, id);
	}

}
