package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Set;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    public void add(Accident accident) {
        accidents.put(accidents.size()+1, accident);
    }

    public HashMap<Integer, Accident> findAllAccidents(){
        return accidents;
    }
}
