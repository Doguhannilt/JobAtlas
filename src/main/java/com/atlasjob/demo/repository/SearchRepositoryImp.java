package com.atlasjob.demo.repository;

import com.atlasjob.demo.model.postModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImp implements searchRepository {

    private final MongoCollection<Document> collection;

    @Autowired
    MongoConverter  converter;

    @Autowired
    public SearchRepositoryImp(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("doguhannilt");
        this.collection = database.getCollection("jobPost");
    }

    @Override
    public List<postModel> findByText(String text) {

        final List<postModel> posts = new ArrayList<>();

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("techs", new Document("$exists", true))),
                new Document("$sort", new Document("exp", 1L)),
                new Document("$limit", 5L)
        ));

        result.forEach(doc -> {
            System.out.println(doc.toJson());  // Belgenin JSON temsilini yazdırın
            posts.add(converter.read(postModel.class, doc));
        });

        return posts;
    }
}
