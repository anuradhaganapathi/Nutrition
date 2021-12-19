package com.nutrition.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NutritionDeficiencyRepository extends JpaRepository<NutritionDeficiencyModel,Integer> {

    List<NutritionDeficiencyModel> findBySymptom(String symptom);

}
