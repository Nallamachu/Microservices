package com.cf.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cf.user.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query("from User where email=:email and status='ACTIVE'")
	User findByEmail(@Param(value = "email") String email);

}
