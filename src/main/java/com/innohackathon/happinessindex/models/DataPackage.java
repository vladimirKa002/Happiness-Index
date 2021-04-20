package com.innohackathon.happinessindex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="user_info")
public class DataPackage{
    @Id
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String gender;
    private String address;
    private String workplace;
    private String position;
    private Integer bpm;
    private Integer salary;
    private String performance;
    private String blood_pressure;
    private Integer steps_per_day;
    private Integer visits_sport_clubs;
    private Integer visits_art_clubs;
    private Integer interaction_with_friends;
    private String relationship;
}

