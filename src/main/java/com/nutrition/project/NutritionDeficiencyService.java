package com.nutrition.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionDeficiencyService implements INutritionDeficiencyService {

    @Autowired
    private NutritionDeficiencyRepository nutritionDeficiencyRepository;


    @Override
    public List<NutritionDeficiencyModel> findAll() {
        System.out.println(nutritionDeficiencyRepository.findAll());
        return (List<NutritionDeficiencyModel>) nutritionDeficiencyRepository.findAll();
    }

    @Override
    public List<String> findNutrientsfromSymptoms(List<String> values) {
        for(int i = 0; i< values.size();i++) {
            System.out.println(nutritionDeficiencyRepository.findNutrientsFromSymmptom(values.get(i)));
        }
        return values;
    }
}
