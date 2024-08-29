package com.test.COCONSULT.ServiceIMP;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;
import com.test.COCONSULT.Interfaces.HistoriqueTimeOffInterface;
import com.test.COCONSULT.Reposotories.HisoriqueTimeOffRepo;
import com.test.COCONSULT.Reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class HistoriqueTimeOffServiceIMP implements HistoriqueTimeOffInterface {
    @Autowired
    HisoriqueTimeOffRepo hisoriqueTimeOffRepo;



    @Override
    public HistoriqueTimeOff addHistoriqueTimeOff(HistoriqueTimeOff h) {
        return hisoriqueTimeOffRepo.save(h);
    }

    @Override
    public void DeleteHistoriqueTimeOffbyId(Integer idHistoriqueTimeOff) {
        hisoriqueTimeOffRepo.deleteById(idHistoriqueTimeOff);
    }

    @Override
    public HistoriqueTimeOff editHistoriqueTimeOffByID(Integer idHistoriqueTimeOff, HistoriqueTimeOff updatedHistoriqueTimeOff) {
        HistoriqueTimeOff existingHistoriqueTimeOff = hisoriqueTimeOffRepo.findByIdHistoriqueTimeOff(idHistoriqueTimeOff);
        if (existingHistoriqueTimeOff != null) {
            existingHistoriqueTimeOff.setNbreDaysOff(updatedHistoriqueTimeOff.getNbreDaysOff());

            return hisoriqueTimeOffRepo.save(existingHistoriqueTimeOff);
        } else {
            System.out.println("HistoriqueTimeOff dos not exist");
            return null;
        }
    }

    @Override
    public List<HistoriqueTimeOff> getAllHistoriqueTimeOffs() {
        return hisoriqueTimeOffRepo.findAll();
    }

    @Override
    public HistoriqueTimeOff getHistoriqueTimeOffById(Integer idHistoriqueTimeOff) {
        return hisoriqueTimeOffRepo.findByIdHistoriqueTimeOff(idHistoriqueTimeOff);
    }
}
