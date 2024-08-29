package com.test.COCONSULT.ServiceIMP;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;
import com.test.COCONSULT.Entity.TimeOffRaison;
import com.test.COCONSULT.Interfaces.TimeoffRaisonInterface;
import com.test.COCONSULT.Reposotories.TimeoffRaisonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeOffRaisonServiceIMP implements TimeoffRaisonInterface {
    @Autowired
    TimeoffRaisonRepo timeoffRaisonRepo;

    @Override
    public TimeOffRaison addTimeOffRaison(TimeOffRaison timeOffRaison) {
        return timeoffRaisonRepo.save(timeOffRaison);
    }

    @Override
    public void deleteTimeOffRaisonById(Integer idTimeoffRaison) {
        timeoffRaisonRepo.deleteById(idTimeoffRaison);
    }

    @Override
    public TimeOffRaison editTimeOffRaisonByID(Integer idTimeoffRaison, TimeOffRaison updatedTimeOffRaison) {
        TimeOffRaison existingTimeOffRaison = timeoffRaisonRepo.findByIdTimeoffRaison(idTimeoffRaison);
        if (existingTimeOffRaison != null) {
            existingTimeOffRaison.setRaison(updatedTimeOffRaison.getRaison());

            return timeoffRaisonRepo.save(existingTimeOffRaison);
        } else {
            System.out.println("TimeOffRaison dos not exist");
            return null;
        }    }

    @Override
    public List<TimeOffRaison> getAllTimeOffRaisons() {
        return timeoffRaisonRepo.findAll();
    }

    @Override
    public TimeOffRaison getTimeOffRaisonById(Integer idTimeoffRaison) {
        return timeoffRaisonRepo.findByIdTimeoffRaison(idTimeoffRaison);
    }
}
