package ru.job4j.incident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.incident.model.Accident;
import ru.job4j.incident.model.AccidentType;
import ru.job4j.incident.model.Rule;
import ru.job4j.incident.repository.AccidentJdbcTemplate;
import ru.job4j.incident.repository.AccidentMem;
import ru.job4j.incident.service.AccService;
import ru.job4j.incident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccidentControl {
    private final AccService accidentService;

    public AccidentControl(AccService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = accidentService.findAllAccidentType();
        model.addAttribute("types", types);

        List<Rule> rules = accidentService.findAllRule();
        model.addAttribute("rules", rules);

        return "incident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidentService.add(accident, ids);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidentService.findAllAccidentType();
        List<Rule> rules = accidentService.findAllRule();
        AccidentType type = accidentService.findByIdType(1);
        Accident acc = accidentService.findById(id);
        model.addAttribute("types", types);
        model.addAttribute("accident", acc);
        model.addAttribute("rules", rules);
        return "incident/edit";
    }

}
