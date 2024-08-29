package com.test.COCONSULT.Interfaces;

import com.test.COCONSULT.Entity.RequestTimeOff;
import com.test.COCONSULT.Entity.TimeOffRaison;

import java.util.List;

public interface RequestTimeOffInterface {

    RequestTimeOff addRequestTimeOff(RequestTimeOff requestTimeOff);

    void deleteRequestTimeOffById(Integer idRequestTimeOff);

    RequestTimeOff editRequestTimeOffByID(Integer idRequestTimeOff, RequestTimeOff updatedRequestTimeOff);

    List<RequestTimeOff> getAllRequestTimeOff();

    RequestTimeOff getRequestTimeOffById(Integer idRequestTimeOff);
}
