package com.nutrition.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class NutritionDeficiencyController {
    @Autowired
    NutritionDeficiencyRepository nutritionDeficiencyRepository;

    @CrossOrigin(origins = "http://localhost:8080 ")
    @GetMapping("symptomlist")
    public List<NutritionDeficiencyModel> findSymptoms(Model model) {
        var symptoms = (List<NutritionDeficiencyModel>) nutritionDeficiencyRepository.findAll();
        System.out.println(symptoms);
        model.addAttribute("symptoms",symptoms);
        return symptoms;
    }

    @GetMapping("symptomlist/symptom")
    public List<String> getNutrientsBySymptom(@RequestParam String symptom) {
        List<String> nutrientsList = new java.util.ArrayList<>(List.of());
        System.out.println("Symptom selected" + symptom);
        var nutrients = (List<NutritionDeficiencyModel>) nutritionDeficiencyRepository.findBySymptom(symptom);
        nutrients.forEach(nutrient -> nutrientsList.add(nutrient.getNutrient()));
        nutrientsList.forEach(System.out::println);

        return nutrientsList;
    }
}
