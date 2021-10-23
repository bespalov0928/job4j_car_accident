package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.HashMap;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        Accident acc1 = new Accident("acc1", "descr1", "addres1");
        Accident acc2 = new Accident("acc2", "descr2", "addres2");
        Accident acc3 = new Accident("acc3", "descr3", "addres3");
        AccidentMem accidentMem = new AccidentMem();
        accidentMem.add(acc1);
        accidentMem.add(acc2);
        accidentMem.add(acc3);
        HashMap<Integer, Accident> accidents = accidentMem.findAllAccidents();
        model.addAttribute("accidents", accidents.values());
        return "index";
    }
}
