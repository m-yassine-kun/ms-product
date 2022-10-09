package com.hackaton.msproduct.dao;

import com.hackaton.msproduct.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepo extends MongoRepository<Category,String> {
}
