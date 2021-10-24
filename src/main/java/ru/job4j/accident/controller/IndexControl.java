package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");

        AccidentService accidentService = new AccidentService();

        ArrayList<Accident> listAccidents = new ArrayList<>();
        Accident acc1 = accidentService.createAccident("acc1", "descr1", "addres1");
        Accident acc2 = accidentService.createAccident("acc2", "descr2", "addres2");
        Accident acc3 = accidentService.createAccident("acc3", "descr3", "addres3");
        listAccidents.add(acc1);
        listAccidents.add(acc2);
        listAccidents.add(acc3);
        AccidentMem accidentMem = new AccidentMem(listAccidents);

        ArrayList<Accident> accidents = accidentMem.findAllAccidents();
        model.addAttribute("accidents", accidents);
        return "index";
    }
}
