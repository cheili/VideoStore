package net.claudeheili.videostore.repository;

import org.springframework.data.repository.CrudRepository;

import net.claudeheili.videostore.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
