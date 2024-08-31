package com.test.COCONSULT.Reposotories;

import com.test.COCONSULT.DTO.StatuRequest;
import com.test.COCONSULT.Entity.RequestTimeOff;
import com.test.COCONSULT.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestTimeeoffRepo  extends JpaRepository<RequestTimeOff,Integer> {
    RequestTimeOff findByIdRequestTimeOff(Integer idRequestTimeOff);

    List<RequestTimeOff> findByUser(User user);

    List<RequestTimeOff> findByUserAndStatuRequest(User user, StatuRequest statuRequest);

    @Query("SELECT YEAR(r.startDate) as year, SUM(r.Duration) as totalDays FROM RequestTimeOff r WHERE r.user = :user AND r.statuRequest = :statuRequest GROUP BY YEAR(r.startDate)")
    List<Object[]> findTotalAcceptedDaysByUserAndYear(User user, StatuRequest statuRequest);
}


