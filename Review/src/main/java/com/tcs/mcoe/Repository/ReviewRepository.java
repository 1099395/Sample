package com.tcs.mcoe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.mcoe.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String>{

}

