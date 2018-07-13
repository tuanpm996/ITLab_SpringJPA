package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import model.Item;
import model.Category;
import service.CategoryService;
import service.ItemService;

@SpringBootApplication(scanBasePackages = { "service", "model", "repository" })
@EnableJpaRepositories("repository")
@EntityScan("model")
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Item> items = itemService.findByCategory("ahihi", 0, 2);
		System.out.println("items: " + items.size());
		for (Item item : items) {
			System.out.println(item.getId() + ": " + item.getName());
		}

		List<Category> categories = categoryService.findByType("abc", 0, 1);
		System.out.println("categories: " + categories.size());
		for (Category category : categories) {
			System.out.println(category.getId() + ": " + category.getName());
		}
		categoryService.update(1, "ahihi");
	}

}
