package com.nutrition.project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NutritionDeficiencyRepository extends CrudRepository<NutritionDeficiencyModel,Integer> {

    @Query(value = "SELECT Nutrient FROM NutritionDeficiencyModel WHERE SYMPTOM = ?1", nativeQuery = true)
    List<String> findNutrientsFromSymmptom(String symptom);

}
