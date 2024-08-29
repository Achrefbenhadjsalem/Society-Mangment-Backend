package com.test.COCONSULT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.COCONSULT.DTO.StatuRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class RequestTimeOff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRequestTimeOff;
    private Date startDate;
    private Double Duration;
    private StatuRequest statuRequest;

    @ManyToOne
    private User user;

    @OneToOne
    @JsonIgnore
    private TimeOffRaison timeOffRaison;

    @ManyToOne
    @JsonIgnore
    private  HistoriqueTimeOff historiqueTimeOff;




}
