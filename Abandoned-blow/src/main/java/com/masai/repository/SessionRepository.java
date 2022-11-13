package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exception.InvalidCredentialsException;
import com.masai.model.CurrentUserLoginSession;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserLoginSession, Integer> {
	
	public Optional<CurrentUserLoginSession> findByUserId(Integer userId) throws InvalidCredentialsException;
	
	@Query(value = "select c from CurrentUserLoginSession c where c.authKey=?1")
	public Optional<CurrentUserLoginSession> findByAuthKey(String authKey);
}
