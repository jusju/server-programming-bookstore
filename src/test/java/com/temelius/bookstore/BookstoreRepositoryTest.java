package com.temelius.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.temelius.bookstore.domain.Book;
import com.temelius.bookstore.domain.BookstoreRepository;
import com.temelius.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	
	@Autowired
	private BookstoreRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("Animal Farm");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("David Sklar", "PHP Cookbook", "9781449363758", "2014", crepository.findByName("Programming").get(0));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		brepository.delete(brepository.findByTitle("Animal Farm").get(0));
		List<Book> books = brepository.findByTitle("Animal Farm");
		assertThat(books).hasSize(0);
		
	}
}
