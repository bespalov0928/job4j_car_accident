package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;


import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;
    private AccidentService accidentService = new AccidentService();

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(){
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident){
        accidentService.generateId(accident);
        accidents.add(accident);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String edit(){
        return "accident/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Accident accident){
        accidents.edit(Integer.valueOf(accident.getId()), accident);
        return "redirect:/";
    }

}
