package com.nutrition.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class NutritionDeficiencyController {
    @Autowired
    private INutritionDeficiencyService iNutritionDeficiencyService;

    public NutritionDeficiencyController(INutritionDeficiencyService iNutritionDeficiencyService) {
        this.iNutritionDeficiencyService = iNutritionDeficiencyService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String findSymptoms(Model model) {
        var symptoms = (List<NutritionDeficiencyModel>) iNutritionDeficiencyService.findAll();
        System.out.println(symptoms);
        model.addAttribute("symptoms",symptoms);
        return "index";
    }
}
