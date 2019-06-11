package com.example.demo.Service;

import com.example.demo.models.Stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatsRepo extends CrudRepository<Stats, Long> {
}