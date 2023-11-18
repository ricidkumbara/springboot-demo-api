package com.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.Product;
import com.domain.models.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> product =  productRepository.findById(id);

        if (!product.isPresent()) {
            return null;
        }
        
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContains(name);
    }

}
