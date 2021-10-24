package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.*;

@Repository
public class AccidentMem {
    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem(ArrayList<Accident> listAccidents) {
        for (Accident acc : listAccidents) {
            if (!accidents.containsValue(acc)) {
                accidents.put(acc.getId(), acc);
            }
        }
    }

    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

}
