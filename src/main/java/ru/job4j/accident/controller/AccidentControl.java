package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.*;
import ru.job4j.accident.service.AccService;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentServiceSpringData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccidentControl {
    private final AccidentServiceSpringData accidentService;

    public AccidentControl(AccidentServiceSpringData accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = accidentService.findAllAccidentType();
        model.addAttribute("types", types);

        List<Rule> rules = accidentService.findAllRule();
        model.addAttribute("rules", rules);

        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidentService.add(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidentService.findAllAccidentType();
        List<Rule> rules = accidentService.findAllRule();
        Accident acc = accidentService.findById(id);
        model.addAttribute("types", types);
        model.addAttribute("accident", acc);
        model.addAttribute("rules", rules);
        return "accident/edit";
    }

}
