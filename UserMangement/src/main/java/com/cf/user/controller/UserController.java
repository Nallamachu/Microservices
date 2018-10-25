package com.cf.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.user.bean.Status;
import com.cf.user.bean.User;
import com.cf.user.dao.UserDao;
import com.cf.user.util.PasswordUtil;


@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserDao uDao;

	@GetMapping(path = "/getuser")
	public User userByMail(@RequestParam String email) {
		return uDao.findByEmail(email);
	}

	@GetMapping(path = "/validate")
	public boolean validateUser(@RequestParam String email, @RequestParam String password) {
		User user = uDao.findByEmail(email);
		if (user != null) {
			if (password.equals(PasswordUtil.decrypt(user.getPassword())))
				return true;
			else
				return false;
		}
		return false;
	}

	@SuppressWarnings("null")
	@PostMapping(path = "/default")
	public User createDefaultUser() {
		String email = "temp@management.com";
		User user = uDao.findByEmail(email);
		if (user != null) {
			return user;
		} else {
			user.setEmail(email);
			user.setPassword(PasswordUtil.encrypt("Temp@123"));
			user.setStatus(Status.ACTIVE.toString());
			uDao.saveAndFlush(user);
		}
		return user;
	}

}
