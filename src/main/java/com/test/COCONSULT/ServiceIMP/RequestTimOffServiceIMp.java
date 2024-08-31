package com.test.COCONSULT.ServiceIMP;

import com.test.COCONSULT.DTO.StatuRequest;
import com.test.COCONSULT.Entity.RequestTimeOff;
import com.test.COCONSULT.Entity.TimeOffRaison;
import com.test.COCONSULT.Entity.User;
import com.test.COCONSULT.Interfaces.RequestTimeOffInterface;
import com.test.COCONSULT.Reposotories.RequestTimeeoffRepo;
import com.test.COCONSULT.Reposotories.TimeoffRaisonRepo;
import com.test.COCONSULT.Reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RequestTimOffServiceIMp implements RequestTimeOffInterface {
    @Autowired
    RequestTimeeoffRepo requestTimeeoffRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TimeoffRaisonRepo timeoffRaisonRepo;

    @Override
    public RequestTimeOff addRequestTimeOff(RequestTimeOff requestTimeOff, Integer timeOffRaisonId) {
        // Get the currently logged-in user
        String username = getCurrentUsername();
        System.out.println("Current logged-in username: " + username);  // Debug line

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the TimeOffRaison by id
        TimeOffRaison timeOffRaison = timeoffRaisonRepo.findByIdTimeoffRaison(timeOffRaisonId);
        // Assign the user and timeOffRaison to the request
        requestTimeOff.setUser(user);
        requestTimeOff.setTimeOffRaison(timeOffRaison);

        // Save the request with the associated user and timeOffRaison
        return requestTimeeoffRepo.save(requestTimeOff);
    }

    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @Override
    public void deleteRequestTimeOffById(Integer idRequestTimeOff) {
        requestTimeeoffRepo.deleteById(idRequestTimeOff);

    }

    @Override
    public RequestTimeOff editRequestTimeOffByID(Integer idRequestTimeOff, RequestTimeOff updatedRequestTimeOff) {
        RequestTimeOff existingRequestTimeOff = requestTimeeoffRepo.findByIdRequestTimeOff(idRequestTimeOff);
        if (existingRequestTimeOff != null) {
            existingRequestTimeOff.setStatuRequest(updatedRequestTimeOff.getStatuRequest());
            existingRequestTimeOff.setDuration(updatedRequestTimeOff.getDuration());
            existingRequestTimeOff.setStartDate(updatedRequestTimeOff.getStartDate());
            return requestTimeeoffRepo.save(existingRequestTimeOff);
        } else {
            System.out.println("RequestTimeOff dos not exist");
            return null;
        }     }

    @Override
    public List<RequestTimeOff> getAllRequestTimeOff() {
        return requestTimeeoffRepo.findAll();
    }

    @Override
    public RequestTimeOff getRequestTimeOffById(Integer idRequestTimeOff) {
        return requestTimeeoffRepo.findByIdRequestTimeOff(idRequestTimeOff);
    }
    @Override
    public List<RequestTimeOff> getRequestTimeOffByUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return requestTimeeoffRepo.findByUser(user);
    }

    @Override
    public List<RequestTimeOff> getAcceptedRequestTimeOffByUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return requestTimeeoffRepo.findByUserAndStatuRequest(user, StatuRequest.Accepted);
    }

    @Override
    public Map<Integer, Double> getAcceptedDaysByUserAndYear(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Object[]> results = requestTimeeoffRepo.findTotalAcceptedDaysByUserAndYear(user, StatuRequest.Accepted);

        return results.stream()
                .collect(Collectors.toMap(
                        result -> (Integer) result[0],  // Year
                        result -> (Double) result[1]     // Total days
                ));
    }


}
