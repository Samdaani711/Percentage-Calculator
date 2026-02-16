package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.calculate;

@Controller
public class marks {

    @Autowired
    private calculate calculate;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateMarks(@RequestParam String name,
                                 @RequestParam int marks1,
                                 @RequestParam int marks2,
                                 @RequestParam int marks3,
                                 Model model) {

        // ✅ Validation
        if (marks1 > 100 || marks2 > 100 || marks3 > 100 ||
            marks1 < 0 || marks2 < 0 || marks3 < 0) {

            model.addAttribute("error",
                    "Marks should be between 0 and 100 only!");

            return "result";
        }

        double percentage = calculate.calculatePercentage(marks1, marks2, marks3);

        model.addAttribute("name", name);
        model.addAttribute("percentage", percentage);

        return "result";
    }
}

