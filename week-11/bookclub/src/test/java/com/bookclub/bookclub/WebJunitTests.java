package com.bookclub.bookclub;
import com.bookclub.web.WishlistController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebJunitTests {
	
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
	//Web Junit test #1 : Check the localhost:8080/ with index.html page that has Login Form
	@Test
    public void UsernameMatch() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "",
                String.class)).contains("Username");
    }
	
	@Test
    public void PasswordMatch() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "",
                String.class)).contains("Password");
    }
}
