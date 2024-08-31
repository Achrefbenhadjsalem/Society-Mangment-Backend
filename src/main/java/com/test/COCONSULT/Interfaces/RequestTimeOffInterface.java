package com.test.COCONSULT.Interfaces;

import com.test.COCONSULT.Entity.RequestTimeOff;
import com.test.COCONSULT.Entity.TimeOffRaison;

import java.util.List;
import java.util.Map;

public interface RequestTimeOffInterface {

    RequestTimeOff addRequestTimeOff(RequestTimeOff requestTimeOff, Integer timeOffRaisonId);

    void deleteRequestTimeOffById(Integer idRequestTimeOff);

    RequestTimeOff editRequestTimeOffByID(Integer idRequestTimeOff, RequestTimeOff updatedRequestTimeOff);

    List<RequestTimeOff> getAllRequestTimeOff();

    RequestTimeOff getRequestTimeOffById(Integer idRequestTimeOff);

    List<RequestTimeOff> getRequestTimeOffByUser(String username);

    List<RequestTimeOff> getAcceptedRequestTimeOffByUser(String username);

    Map<Integer, Double> getAcceptedDaysByUserAndYear(String username) ;

    }
