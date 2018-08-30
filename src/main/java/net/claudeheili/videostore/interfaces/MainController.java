
package net.claudeheili.videostore.interfaces;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import net.claudeheili.videostore.model.Movie;
import net.claudeheili.videostore.model.User;

public interface MainController {

	String addNewUser(@RequestParam String name, @RequestParam String email) throws Exception;
	Iterable<User> getAllUsers() throws Exception;
	Optional<User> getUserById(@PathVariable("id") int id) throws Exception;
	Iterable<Movie> getMovies();
}
