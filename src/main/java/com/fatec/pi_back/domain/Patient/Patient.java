package com.fatec.pi_back.domain.Patient;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String condition;
    private Boolean selfCare;
    
    public Patient(String name, Integer age, String condition, Boolean selfCare){
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.selfCare = selfCare;
    }
}
