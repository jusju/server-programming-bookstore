package com.temelius.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.temelius.bookstore.domain.Book;
import com.temelius.bookstore.domain.BookstoreRepository;

@SpringBootApplication
public class BookstoreApplication {
		
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Bookstore(BookstoreRepository repository) {
		return (args) -> {
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", "1929"));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", "1945"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Philosopher’s Stone", "951-31-1146-6", "1997"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Chamber of Secrets", "951-31-1472-4", "1998"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Prisoner of Azkaban", "951-31-1737-5", "1999"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Goblet of Fire", "951-31-2038-4", "2000"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Order of the Phoenix", "951-31-2907-1", "2003"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Half-Blood Prince", "951-31-3507-1", "2005"));
			repository.save(new Book("J. K. Rowling", "Harry Potter and the Deathly Hallows", "978-951-31-4004-5", "2007"));
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
