package com.nutrition.project;

import java.util.List;

public interface INutritionDeficiencyService {
    List<NutritionDeficiencyModel> findAll();

    List<String> findNutrientsfromSymptoms(List<String> values);
}
