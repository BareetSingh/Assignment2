package com.io.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.io.model.ProductData;

@Repository
public interface Repo extends MongoRepository<ProductData , String> {

}
