package com.test.COCONSULT.Controllers;

import com.test.COCONSULT.Entity.TimeOffRaison;
import com.test.COCONSULT.Reposotories.TimeoffRaisonRepo;
import com.test.COCONSULT.ServiceIMP.TimeOffRaisonServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TimeOffRaison")
public class TimeOffRaisonController  {
    @Autowired
    TimeOffRaisonServiceIMP timeOffRaisonServiceIMP;
    @Autowired
    TimeoffRaisonRepo timeoffRaisonRepo;
    @PostMapping("/addTimeOffRaison")
    public TimeOffRaison addTimeOffRaison(@RequestBody TimeOffRaison timeOffRaison) {
        return timeOffRaisonServiceIMP.addTimeOffRaison(timeOffRaison);
    }
    @PutMapping("/editTimeOffRaisonByID/{idTimeoffRaison}")
    public TimeOffRaison editTimeOffRaisonByID(@PathVariable("idTimeoffRaison") Integer idTimeoffRaison,@RequestBody TimeOffRaison updatedTimeOffRaison) {
        return timeOffRaisonServiceIMP.editTimeOffRaisonByID(idTimeoffRaison, updatedTimeOffRaison);
    }
    @DeleteMapping("/deleteTimeOffRaisonById/{idTimeoffRaison}")
    public void deleteTimeOffRaisonById(@PathVariable("idTimeoffRaison") Integer idTimeoffRaison) {
        timeOffRaisonServiceIMP.deleteTimeOffRaisonById(idTimeoffRaison);
    }
    @GetMapping("/getAllTimeOffRaisons")
    public List<TimeOffRaison> getAllTimeOffRaisons() {
        return timeOffRaisonServiceIMP.getAllTimeOffRaisons();
    }
    @GetMapping("/getTimeOffRaisonById/{idTimeoffRaison}")
    public TimeOffRaison getTimeOffRaisonById(@PathVariable("idTimeoffRaison") Integer idTimeoffRaison) {
        return timeOffRaisonServiceIMP.getTimeOffRaisonById(idTimeoffRaison);
    }
}
