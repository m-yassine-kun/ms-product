package com.hackaton.msproduct.dao;

import com.hackaton.msproduct.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepo extends MongoRepository<Product,String> {
}
