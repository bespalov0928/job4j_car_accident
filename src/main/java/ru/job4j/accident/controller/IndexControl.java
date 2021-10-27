package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;


@Controller
public class IndexControl {

    private AccidentService accidentServic = new AccidentService();
    private final AccidentMem accidentMem = new AccidentMem();

    public IndexControl(AccidentService accidentServic) {
        this.accidentServic = accidentServic;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");


        ArrayList<Accident> accidents = accidentMem.findAllAccidents();
        model.addAttribute("accidents", accidents);
        return "index";
    }
}
