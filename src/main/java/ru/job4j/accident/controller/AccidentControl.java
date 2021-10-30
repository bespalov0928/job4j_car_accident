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
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class AccidentControl {
    private final AccidentMem accidents = AccidentMem.getInstance();
    private AccidentService accidentService = AccidentService.getInstance();

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        model.addAttribute("types", types);

        List<Rule> rules = accidents.findAllRule();
        model.addAttribute("rules", rules);

        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.add(accident, ids);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        List<Rule> rules = accidents.findAllRule();
        model.addAttribute("types", types);
        model.addAttribute("accident", accidents.findById(id));
        model.addAttribute("rules", rules);
        return "accident/edit";
    }

}
