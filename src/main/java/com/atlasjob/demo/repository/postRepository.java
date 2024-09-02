package com.atlasjob.demo.repository;

import com.atlasjob.demo.model.postModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface postRepository extends MongoRepository<postModel, String> {
}
