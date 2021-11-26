package com.nutrition.project;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "mytable")
@Entity
public class NutritionDeficiencyModel {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptom() {
        return Symptom;
    }

    public void setSymptom(String symptom) {
        Symptom = symptom;
    }

    public String getNutrient() {
        return Nutrient;
    }

    public void setNutrient(String nutrient) {
        Nutrient = nutrient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Symptom;

    private String Nutrient;

}
