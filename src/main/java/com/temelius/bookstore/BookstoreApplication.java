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
			
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
