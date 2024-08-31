package com.test.COCONSULT.Controllers;

import com.test.COCONSULT.Entity.HistoriqueTimeOff;
import com.test.COCONSULT.Reposotories.HisoriqueTimeOffRepo;
import com.test.COCONSULT.ServiceIMP.HistoriqueTimeOffServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/HistoriqueTimeOff")
public class HisotriqueTimeOffController {
    @Autowired
    HistoriqueTimeOffServiceIMP historiqueTimeOffServiceIMP;
    @Autowired
    HisoriqueTimeOffRepo hisoriqueTimeOffRepo;
    @PostMapping("/addHistoriqueTimeOff")
    public HistoriqueTimeOff addHistoriqueTimeOff(@RequestBody HistoriqueTimeOff h) {
        return historiqueTimeOffServiceIMP.addHistoriqueTimeOff(h);
    }
    @GetMapping("/getAllHistoriqueTimeOffs")
    public List<HistoriqueTimeOff> getAllHistoriqueTimeOffs() {
        return historiqueTimeOffServiceIMP.getAllHistoriqueTimeOffs();
    }
    @PutMapping("/editHistoriqueTimeOffByID/{idHistoriqueTimeOff}")
    public HistoriqueTimeOff editHistoriqueTimeOffByID(@PathVariable("idHistoriqueTimeOff") Integer idHistoriqueTimeOff,@RequestBody HistoriqueTimeOff updatedHistoriqueTimeOff) {
        return historiqueTimeOffServiceIMP.editHistoriqueTimeOffByID(idHistoriqueTimeOff, updatedHistoriqueTimeOff);
    }
    @DeleteMapping("/DeleteHistoriqueTimeOffbyId/{idHistoriqueTimeOff}")
    public void DeleteHistoriqueTimeOffbyId(@PathVariable("idHistoriqueTimeOff") Integer idHistoriqueTimeOff) {
        historiqueTimeOffServiceIMP.DeleteHistoriqueTimeOffbyId(idHistoriqueTimeOff);
    }
    @GetMapping("/getHistoriqueTimeOffById/{idHistoriqueTimeOff}")
    public HistoriqueTimeOff getHistoriqueTimeOffById(@PathVariable("idHistoriqueTimeOff") Integer idHistoriqueTimeOff) {
        return historiqueTimeOffServiceIMP.getHistoriqueTimeOffById(idHistoriqueTimeOff);
    }



}
