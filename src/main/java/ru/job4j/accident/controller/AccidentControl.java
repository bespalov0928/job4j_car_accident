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
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.service.AccidentService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccidentControl {
    private final AccidentJdbcTemplate accidents;
    private AccidentService accidentService = AccidentService.getInstance();

    public AccidentControl(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }

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
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        List<Rule> rules = accidents.findAllRule();
        Accident acc = accidents.findById(id);
        model.addAttribute("types", types);
        model.addAttribute("accident", acc);
        model.addAttribute("rules", rules);
        return "accident/edit";
    }

}
