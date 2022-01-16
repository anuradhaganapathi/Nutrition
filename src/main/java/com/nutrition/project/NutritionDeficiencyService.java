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
        return (List<NutritionDeficiencyModel>) nutritionDeficiencyRepository.findAll();
    }
}
