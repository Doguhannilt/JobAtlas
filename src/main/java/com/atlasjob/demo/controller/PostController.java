package com.atlasjob.demo.controller;

import com.atlasjob.demo.model.postModel;
import com.atlasjob.demo.repository.postRepository;
import com.atlasjob.demo.repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private postRepository repo;

    @Autowired
    private searchRepository srepo;


    @GetMapping
    public List<postModel> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/{text}")
    public List<postModel> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @PostMapping
    public postModel addPost(@RequestBody postModel post){
        return repo.save(post);
    }



}