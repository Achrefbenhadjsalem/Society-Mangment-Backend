package com.test.COCONSULT.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class TimeOffRaison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTimeoffRaison;
    private String raison;


}
