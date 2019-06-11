package com.example.demo.Service;

import com.example.demo.models.Stats;

import java.util.List;

public interface IStatsService {
    boolean add(Stats student);
    List<Stats> findAll();
}
