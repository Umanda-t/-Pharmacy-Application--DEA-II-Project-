package com.example.deaii_sbp_project;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;

    //public List<Product> listAll() { return repo.findAll(); }
    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    public void save(Product product) {
        repo.save(product);
    }

    public Product get(long id) {
        return repo.findById(id).get();
    }
    public void delete(long id) {
        repo.deleteById(id);
    }
}
