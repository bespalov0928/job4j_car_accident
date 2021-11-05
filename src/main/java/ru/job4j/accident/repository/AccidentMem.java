package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import java.util.*;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents = new HashMap<>();
    private Map<Integer, AccidentType> types = new HashMap<>();
    private List<Rule> rules = new ArrayList<>();

    private AccidentMem() {

        if (types.size() == 0) {
            types.put(1, AccidentType.of(1, "Две машины"));
            types.put(2, AccidentType.of(2, "Машина и человек"));
            types.put(3, AccidentType.of(3, "Машина и велосипед"));

        }

        if (rules.size() == 0) {
            rules.add(Rule.of(1, "Статья. 1"));
            rules.add(Rule.of(2, "Статья. 2"));
            rules.add(Rule.of(3, "Статья. 3"));
        }

    }

    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public void add(Accident accident, String[] rIds) {
        for (String r : rIds) {
            Rule rule = rules.get(Integer.valueOf(r) - 1);
            accident.addRule(rule);
        }
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
        return rules;
    }

    public Rule findByIdRule(Integer id) {
        Rule rsl = rules.get(id);
        return rsl;
    }

}
