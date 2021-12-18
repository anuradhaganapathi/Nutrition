package com.nutrition.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NutritionDeficiencyController {
    @Autowired
    private INutritionDeficiencyService iNutritionDeficiencyService;

    public NutritionDeficiencyController(INutritionDeficiencyService iNutritionDeficiencyService) {
        this.iNutritionDeficiencyService = iNutritionDeficiencyService;
    }

    @CrossOrigin(origins = "http://localhost:8080 ")
    @GetMapping("symptomlist")
    public List<NutritionDeficiencyModel> findSymptoms(Model model) {
        var symptoms = (List<NutritionDeficiencyModel>) iNutritionDeficiencyService.findAll();
        System.out.println(symptoms);
        model.addAttribute("symptoms",symptoms);
        return symptoms;
    }

    /*public List<NutritionDeficiencyModel> findNutrientBySymptoms(Model model) {
        var nutrients = iNutritionDeficiencyService.findNutrientsfromSymptoms((List<String>) model.getAttribute("selected")));

    }*/

    @GetMapping("symptomlist/{symptom}")
    public List<String> findNutrientBySymptom(@PathVariable String symptom) {
        var nutrients = iNutritionDeficiencyService.findNutrientsfromSymptoms(symptom);
        System.out.println(nutrients);
        return nutrients;
    }
}
