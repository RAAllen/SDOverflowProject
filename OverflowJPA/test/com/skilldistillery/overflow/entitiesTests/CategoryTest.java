package com.skilldistillery.overflow.entitiesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Category;

class CategoryTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Category category;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTrackerProject");
		em = emf.createEntityManager();
		category = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		category = null;
	}

	@Test
	@DisplayName("Test Category is correctly mapped")
	void test_category_mappings() {
		assertEquals("", category.getId());
		assertEquals("", category.getName());
		assertEquals("", category.getDescription());
	}

}
