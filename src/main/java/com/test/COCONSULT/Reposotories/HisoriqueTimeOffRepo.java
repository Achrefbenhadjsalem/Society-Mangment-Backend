package com.test.COCONSULT.Reposotories;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HisoriqueTimeOffRepo extends JpaRepository<HistoriqueTimeOff,Integer> {

    HistoriqueTimeOff findByIdHistoriqueTimeOff(Integer idHistoriqueTimeOff);



}
