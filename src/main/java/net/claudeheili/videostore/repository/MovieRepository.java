package net.claudeheili.videostore.repository;

import org.springframework.data.repository.CrudRepository;

import net.claudeheili.videostore.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
