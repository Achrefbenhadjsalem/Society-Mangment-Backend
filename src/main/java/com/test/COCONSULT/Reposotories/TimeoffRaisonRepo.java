package com.test.COCONSULT.Reposotories;

import com.test.COCONSULT.Entity.TimeOffRaison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeoffRaisonRepo extends JpaRepository<TimeOffRaison,Integer> {
    TimeOffRaison findByIdTimeoffRaison(Integer idTimeoffRaison);
}
