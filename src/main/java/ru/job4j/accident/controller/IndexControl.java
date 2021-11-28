package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.service.AccService;
import ru.job4j.accident.service.AccidentService;

import java.util.List;


@Controller
public class IndexControl {

    private final AccidentRepository accidentService;

    public IndexControl(AccidentRepository accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidentList = null;
        accidentList = accidentService.findAll();
        model.addAttribute("accidents", accidentList);
        return "index";
    }
}
