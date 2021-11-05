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
    private final AccidentMem accidents;

    public AccidentService(AccidentMem accidents) {
        this.accidents = accidents;
        List<Accident> listAcc = accidents.findAllAccidents();
        if (listAcc.size() == 0) {
            AccidentType type1 = accidents.findByIdType(1);
            AccidentType type2 = accidents.findByIdType(2);
            AccidentType type3 = accidents.findByIdType(3);

            Accident acc1 = Accident.of("acc1", "descr1", "addres1", type1);
            Accident acc2 = Accident.of("acc2", "descr2", "addres2", type2);
            Accident acc3 = Accident.of("acc3", "descr3", "addres3", type3);
            acc1.setId(counter.incrementAndGet());
            acc2.setId(counter.incrementAndGet());
            acc3.setId(counter.incrementAndGet());

            acc1.addRule(accidents.findByIdRule(Integer.valueOf(1)));
            acc2.addRule(accidents.findByIdRule(Integer.valueOf(2)));
            acc3.addRule(accidents.findByIdRule(Integer.valueOf(3)));

            accidents.add(acc1);
            accidents.add(acc2);
            accidents.add(acc3);
        }
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

    public List<Rule> findAllRule() {
        return accidents.findAllRule();
    }

}
