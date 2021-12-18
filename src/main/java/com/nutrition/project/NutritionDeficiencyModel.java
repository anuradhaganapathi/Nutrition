package com.nutrition.project;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "mytable")
@Entity
public class NutritionDeficiencyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Symptom;

    private String Nutrient;

}
