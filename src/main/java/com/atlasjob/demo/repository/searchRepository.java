package com.atlasjob.demo.repository;

import com.atlasjob.demo.model.postModel;

import java.util.List;

public interface searchRepository {


    List<postModel> findByText(String text);
}
