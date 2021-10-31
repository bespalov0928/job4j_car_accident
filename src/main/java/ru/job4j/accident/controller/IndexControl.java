package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import java.util.List;


@Controller
public class IndexControl {

    private AccidentService accidentServic = AccidentService.getInstance();
    private final AccidentMem accidentMem = AccidentMem.getInstance();
    private final AccidentJdbcTemplate accidents;



    public IndexControl(AccidentJdbcTemplate accidents) {
        this.accidentServic = accidentServic;
        this.accidents = accidents;
    }



    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidentList = null;
        try {
            accidentList = accidents.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("accidents", accidentList);
        return "index";
    }
}
