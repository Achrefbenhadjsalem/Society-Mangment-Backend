package com.test.COCONSULT.Interfaces;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;
import com.test.COCONSULT.Entity.TimeOffRaison;

import java.util.List;

public interface TimeoffRaisonInterface {

    TimeOffRaison addTimeOffRaison(TimeOffRaison timeOffRaison);

    void deleteTimeOffRaisonById(Integer idTimeoffRaison );

    TimeOffRaison editTimeOffRaisonByID(Integer idTimeoffRaison, TimeOffRaison updatedTimeOffRaison);

    List<TimeOffRaison> getAllTimeOffRaisons();

    TimeOffRaison getTimeOffRaisonById(Integer idTimeoffRaison);
}
