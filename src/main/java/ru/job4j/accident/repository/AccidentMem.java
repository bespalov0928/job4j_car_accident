package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import java.util.*;

public class AccidentMem {

    private Map<Integer, Accident> accidents = new HashMap<>();
    private Map<Integer, AccidentType> types = new HashMap<>();
    private Map<Integer, Rule> rules = new HashMap<>();

    private AccidentMem() {

        if (types.size() == 0) {
            types.put(1, AccidentType.of(1, "Две машины"));
            types.put(2, AccidentType.of(2, "Машина и человек"));
            types.put(3, AccidentType.of(3, "Машина и велосипед"));
        }

        if (rules.size() == 0) {
            rules.put(1, Rule.of(1, "Статья. 1"));
            rules.put(2, Rule.of(2, "Статья. 2"));
            rules.put(3, Rule.of(3, "Статья. 3"));
        }

        if (accidents.size() == 0) {
            Accident acc1 = Accident.of("acc1", "descr1", "addres1", findByIdType(1));
            Accident acc2 = Accident.of("acc2", "descr2", "addres2", findByIdType(2));
            Accident acc3 = Accident.of("acc3", "descr3", "addres3", findByIdType(3));
            acc1.setId(999);
            acc2.setId(998);
            acc3.setId(997);

            acc1.addRule(findByIdRule(1));
            acc2.addRule(findByIdRule(2));
            acc3.addRule(findByIdRule(3));

            accidents.put(999, acc1);
            accidents.put(998, acc2);
            accidents.put(997, acc3);
        }

    }

    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public void add(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        Accident acc = accidents.get(id);
        return acc;
    }

    public void addType(AccidentType accidentType) {
        if (!types.containsValue(accidentType.getId())) {
            types.put(accidentType.getId(), accidentType);
        }
    }

    public ArrayList<AccidentType> findAllAccidentType() {
        Collection<AccidentType> colRsl = types.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public AccidentType findByIdType(int id) {
        AccidentType acc = types.get(id);
        return acc;
    }

    public List<Rule> findAllRule() {
        Collection<Rule> colRsl = rules.values();
        ArrayList rsl = new ArrayList<Rule>(colRsl);
        return rsl;
    }

    public Rule findByIdRule(Integer id) {
        Rule rsl = rules.get(id);
        return rsl;
    }

}
