package com.temelius.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.temelius.bookstore.domain.Book;
import com.temelius.bookstore.domain.BookstoreRepository;

import com.temelius.bookstore.domain.Category;
import com.temelius.bookstore.domain.CategoryRepository;
import com.temelius.bookstore.domain.User;
import com.temelius.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
		
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Bookstore(BookstoreRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Comics"));
			crepository.save(new Category("Manga"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("Realism"));
			crepository.save(new Category("Satire"));
			crepository.save(new Category("Programming"));
			
			brepository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", "1929", crepository.findByName("Realism").get(0)));
			brepository.save(new Book("George Orwell", "Animal Farm", "2212343-5", "1945", crepository.findByName("Satire").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Philosopher’s Stone", "951-31-1146-6", "1997", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Chamber of Secrets", "951-31-1472-4", "1998", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Prisoner of Azkaban", "951-31-1737-5", "1999", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Goblet of Fire", "951-31-2038-4", "2000", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Order of the Phoenix", "951-31-2907-1", "2003", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Half-Blood Prince", "951-31-3507-1", "2005", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("J. K. Rowling", "Harry Potter and the Deathly Hallows", "978-951-31-4004-5", "2007", crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", "0-330-25864-8", "1979", crepository.findByName("Sci-Fi").get(0)));
			
			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@bookstore.fi"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@bookstore.fi"));

			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
