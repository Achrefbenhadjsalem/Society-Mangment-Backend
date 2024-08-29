package com.test.COCONSULT.Reposotories;

import com.test.COCONSULT.Entity.RequestTimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestTimeeoffRepo  extends JpaRepository<RequestTimeOff,Integer> {
    RequestTimeOff findByIdRequestTimeOff(Integer idRequestTimeOff);
}
