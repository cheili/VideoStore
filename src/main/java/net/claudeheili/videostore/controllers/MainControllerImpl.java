package net.claudeheili.videostore.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.claudeheili.videostore.interfaces.MainController;
import net.claudeheili.videostore.model.Movie;
import net.claudeheili.videostore.model.User;
import net.claudeheili.videostore.repository.MovieRepository;
import net.claudeheili.videostore.repository.UserRepository;

@CrossOrigin
@Controller
@RequestMapping(path = MainControllerImpl.REQUEST_MAPPING_PATH)
public class MainControllerImpl implements MainController {
	
//	public static final String REQUEST_MAPPING_PATH = "/portfolio/videostore-demo";
	public static final String REQUEST_MAPPING_PATH = "/api";

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private MovieRepository movieRepository;
	

	@Override
	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

		User n = new User();	
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		
		return "Saved";
	}

	@Override
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	@Override
	@GetMapping(path = "/movies")
	public @ResponseBody Iterable<Movie> getMovies() {
		
		return movieRepository.findAll();
	}
	
	@Override
	@GetMapping(path = "/user/{id}")
	public @ResponseBody Optional<User> getUserById(@PathVariable("id") int id) {
		
		return userRepository.findById(id);
	}
	
//	@Override
//	@GetMapping(path = "/api/movies/{id}")
//	public @ResponseBody Optional<User> getUserById(@PathVariable("id") int id) {
//		
//		return userRepository.findById(id);
//	}
}