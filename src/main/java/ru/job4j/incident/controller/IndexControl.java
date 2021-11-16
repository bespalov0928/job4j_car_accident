package ru.job4j.incident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.incident.model.Accident;
import ru.job4j.incident.service.AccService;
import ru.job4j.incident.service.AccidentService;

import java.util.List;


@Controller
public class IndexControl {

    private final AccService accidentService;

    public IndexControl(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidentList = null;
        accidentList = accidentService.findAllAccidents();
        model.addAttribute("accidents", accidentList);
        return "index";
    }
}
