package com.example.deaii_sbp_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repo;
    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Bioderma");
        product.setQuantity(60);
        product.setMadein("China");
        product.setPrice(567);


         repo.save(product);



    }
}
