package com.example.demo.Service;

import com.example.demo.models.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService implements IStatsService {

    @Autowired
    private IStatsRepo iStatsRepo;

    @Override
    public boolean add(Stats stats) {

        Stats check = iStatsRepo.save(stats);
        if(check!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<Stats> findAll() {
        return (List<Stats>) iStatsRepo.findAll();
    }

}
