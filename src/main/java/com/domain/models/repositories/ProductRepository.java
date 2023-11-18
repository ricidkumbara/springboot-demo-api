package com.domain.models.repositories;

import com.domain.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String name);

}
