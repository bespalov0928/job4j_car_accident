package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;
    private AccidentService accidentService = new AccidentService();

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        model.addAttribute("types", types);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        if (accident.getId() == 0) {
            accidentService.generateId(accident);
        } else {
            accident.setId(Integer.valueOf(accident.getIdString()));
        }
        accidents.add(accident);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        model.addAttribute("types", types);
        model.addAttribute("accident", accidents.findById(id));
        return "accident/edit";
    }

}
