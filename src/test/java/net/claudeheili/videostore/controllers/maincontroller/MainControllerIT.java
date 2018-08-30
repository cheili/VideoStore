package net.claudeheili.videostore.controllers.maincontroller;


import java.net.URL;
import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import net.claudeheili.videostore.interfaces.MainController;
import net.claudeheili.videostore.model.Movie;
import net.claudeheili.videostore.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerIT implements MainController {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

	@Override
	public String addNewUser(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

  
}