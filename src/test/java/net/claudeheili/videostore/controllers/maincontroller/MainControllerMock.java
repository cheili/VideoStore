package net.claudeheili.videostore.controllers.maincontroller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.claudeheili.videostore.controllers.MainControllerImpl;
import net.claudeheili.videostore.interfaces.MainController;
import net.claudeheili.videostore.model.Movie;
import net.claudeheili.videostore.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerMock implements MainController {

	@Autowired
	private MockMvc mvc;

	@Override
	public String addNewUser(String name, String email) throws Exception {

		return null;
	}

	@Override
	public Iterable<User> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(int id) throws Exception {

		getUserByIdTest();

		return null;
	}

	@Test
	public void getUserByIdTest() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get(MainControllerImpl.REQUEST_MAPPING_PATH + "/user/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"Smith\",\"email\":\"Smith@test.com\"}")));

	}

	@Override
	public Iterable<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}
}