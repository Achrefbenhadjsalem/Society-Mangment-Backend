package com.test.COCONSULT.Interfaces;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;

import java.util.List;

public interface HistoriqueTimeOffInterface {

    HistoriqueTimeOff addHistoriqueTimeOff(HistoriqueTimeOff h);

    void DeleteHistoriqueTimeOffbyId(Integer idHistoriqueTimeOff);

    HistoriqueTimeOff editHistoriqueTimeOffByID(Integer idHistoriqueTimeOff, HistoriqueTimeOff updatedHistoriqueTimeOff);

    List<HistoriqueTimeOff> getAllHistoriqueTimeOffs();

    HistoriqueTimeOff getHistoriqueTimeOffById(Integer idHistoriqueTimeOff);
}
