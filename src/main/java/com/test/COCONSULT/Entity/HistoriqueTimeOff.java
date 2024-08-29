package com.test.COCONSULT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter


public class HistoriqueTimeOff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoriqueTimeOff;
    private Date YearTimeOff;
    private Double NbreDaysOff;

    @OneToMany
    @JsonIgnore
    private List<RequestTimeOff> requestTimeOffs;


}
