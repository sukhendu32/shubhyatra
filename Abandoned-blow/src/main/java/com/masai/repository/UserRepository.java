package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByUserId(Integer userId);
	
	public List<User> findByUserType(String userType);
	
	public List<User> findByName(String name);
	
	public List<User> findByMobile(String mobile);
	
}
