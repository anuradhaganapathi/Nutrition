package com.nutrition.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public Map<String,Long> getNutrientsBySymptom(@RequestParam List<String> symptom) {
        System.out.println("Entrs here");
        List<String> nutrientsList = new java.util.ArrayList<>(List.of());
        System.out.println("Symptom selected" + symptom);
        for (String s : symptom) {
            var nutrients = (List<NutritionDeficiencyModel>) nutritionDeficiencyRepository.findBySymptom(s);
            nutrients.forEach(nutrient -> nutrientsList.add(nutrient.getNutrient()));
        }
        nutrientsList.forEach(System.out::println);
        Map<String, Long> nutrientsCount = nutrientsList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(Map.Entry<String, Long> obj: nutrientsCount.entrySet()) {
            System.out.println(obj.getKey() + ":" + obj.getValue());
        }
        return nutrientsCount;
    }
}
