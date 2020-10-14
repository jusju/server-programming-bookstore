package com.temelius.bookstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.temelius.bookstore.domain.UserRepository;
import com.temelius.bookstore.web.BookstoreController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookstoreController bcontroller;

	@Autowired
	private UserRepository ucontroller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}

}
