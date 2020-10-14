package com.temelius.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.temelius.bookstore.domain.Category;
import com.temelius.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Satire");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Satire");
	}
	
	@Test
	public void createCategory() {
		Category category = new Category("Science");
		crepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		crepository.delete(crepository.findByName("Horror").get(0));
		List<Category> categories = crepository.findByName("Science");
		assertThat(categories).hasSize(0);
	}
}
