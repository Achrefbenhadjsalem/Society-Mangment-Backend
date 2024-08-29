package com.test.COCONSULT.Controllers;

import com.test.COCONSULT.Entity.RequestTimeOff;
import com.test.COCONSULT.Reposotories.RequestTimeeoffRepo;
import com.test.COCONSULT.ServiceIMP.RequestTimOffServiceIMp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RequestTimeOff")
public class RequestTimeOffController {
    @Autowired
    RequestTimeeoffRepo requestTimeeoffRepo;
    @Autowired
    RequestTimOffServiceIMp requestTimOffServiceIMp;
    @PostMapping("/addRequestTimeOff")
    public RequestTimeOff addRequestTimeOff(@RequestBody RequestTimeOff requestTimeOff) {
        return requestTimOffServiceIMp.addRequestTimeOff(requestTimeOff);
    }
    @PutMapping("/editRequestTimeOffByID/{idRequestTimeOff}")
    public RequestTimeOff editRequestTimeOffByID(@PathVariable("idRequestTimeOff") Integer idRequestTimeOff, @RequestBody RequestTimeOff updatedRequestTimeOff) {
        return requestTimOffServiceIMp.editRequestTimeOffByID(idRequestTimeOff, updatedRequestTimeOff);
    }
    @DeleteMapping("/deleteRequestTimeOffById/{idRequestTimeOff}")
    public void deleteRequestTimeOffById(@PathVariable("idRequestTimeOff") Integer idRequestTimeOff) {
        requestTimOffServiceIMp.deleteRequestTimeOffById(idRequestTimeOff);
    }
    @GetMapping("/getAllRequestTimeOff")
    public List<RequestTimeOff> getAllRequestTimeOff() {
        return requestTimOffServiceIMp.getAllRequestTimeOff();
    }
    @GetMapping("/getRequestTimeOffById/{idRequestTimeOff}")
    public RequestTimeOff getRequestTimeOffById(@PathVariable("idRequestTimeOff") Integer idRequestTimeOff) {
        return requestTimOffServiceIMp.getRequestTimeOffById(idRequestTimeOff);
    }
}
