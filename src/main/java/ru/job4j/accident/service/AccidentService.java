package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccidentService {
    private AtomicInteger counter = new AtomicInteger(0);
    private final AccidentJdbcTemplate accidents;

    public AccidentService(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }


    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.findAllAccidents();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public void add(Accident accident, String[] rIds) {
        if (accident.getId() == 0) {
            accident.setId(counter.incrementAndGet());
        }
        AccidentType type = accidents.findByIdType(accident.getType().getId());
        accident.setType(type);

        for (String r : rIds) {
            Rule rule = accidents.findByIdRule(Integer.valueOf(r));
            accident.addRule(rule);
        }

        accidents.add(accident);
    }

    public Accident findById(int id) {
        Accident acc = accidents.findById(id);
        return acc;
    }

    public ArrayList<AccidentType> findAllAccidentType() {
        ArrayList<AccidentType> rsl = accidents.findAllAccidentType();
        return rsl;
    }

    public AccidentType findByIdType(int id) {
        AccidentType acc = accidents.findByIdType(id);
        return acc;
    }


    public List<Rule> findAllRule() {
        return accidents.findAllRule();
    }



}
