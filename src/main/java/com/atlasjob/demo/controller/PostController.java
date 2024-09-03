package com.atlasjob.demo.controller;

import com.atlasjob.demo.model.postModel;
import com.atlasjob.demo.repository.postRepository;
import com.atlasjob.demo.repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<postModel> findPost(@PathVariable("id") String id) {
        Optional<postModel> optionalPost = repo.findById(id);

        if (optionalPost.isPresent()) {
            return ResponseEntity.ok(optionalPost.get());
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<postModel> updateJob(@PathVariable("id") String id, @RequestBody postModel updatedJob) {
        return repo.findById(id)
                .map(job -> {

                    job.setDesc(updatedJob.getDesc());
                    job.setExp(updatedJob.getExp());
                    job.setTechs(updatedJob.getTechs());
                    job.setRank(updatedJob.getRank());
                    job.setTitle(updatedJob.getTitle());


                    postModel savedJob = repo.save(job);

                    return ResponseEntity.ok(savedJob);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}