package ru.job4j.incident.service;

import org.springframework.stereotype.Service;
import ru.job4j.incident.model.Accident;
import ru.job4j.incident.model.AccidentType;
import ru.job4j.incident.model.Rule;
import ru.job4j.incident.repository.AccidentHibernate;
import ru.job4j.incident.repository.AccidentJdbcTemplate;
import ru.job4j.incident.repository.AccidentMem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccidentService implements AccService {
    private AtomicInteger counter = new AtomicInteger(0);
    private final AccidentHibernate accidents;

    public AccidentService(AccidentHibernate accidents) {
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

    public List<AccidentType> findAllAccidentType() {
        List<AccidentType> rsl = accidents.findAllAccidentType();
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
