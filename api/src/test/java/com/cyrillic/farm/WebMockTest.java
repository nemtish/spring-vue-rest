
package com.cyrillic.farm;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.cyrillic.farm.controller.FarmController;
import com.cyrillic.farm.entity.User;
import com.cyrillic.farm.repository.UserRepository;
import com.cyrillic.farm.security.JwtTokenUtil;
import com.cyrillic.farm.service.FarmService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FarmController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FarmService service;
    @MockBean
    private JwtTokenUtil jwtTokenUtil;
    @MockBean
    private UserRepository userRepository;

    public synchronized void before() {
        userRepository.save(new User("user1@test.com", "pass123"));
        userRepository.save(new User("user2@test.com", "pass123"));
    }
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		this.mockMvc.perform(get("/api/v1/user")).andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
	}
}