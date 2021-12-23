package com.shawna.its_project.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawna.its_project.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	Optional<User>findUserById(Long id);
	
}
