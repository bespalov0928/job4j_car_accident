package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.controller.IndexControl;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

import java.util.*;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        AccidentService accidentService = new AccidentService();
        Accident acc1 = accidentService.createAccident("acc1", "descr1", "addres1");
        Accident acc2 = accidentService.createAccident("acc2", "descr2", "addres2");
        Accident acc3 = accidentService.createAccident("acc3", "descr3", "addres3");
        accidents.put(acc1.getId(), acc1);
        accidents.put(acc2.getId(), acc2);
        accidents.put(acc3.getId(), acc3);
    }

    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public void add(Accident accident) {
        if (!accidents.containsValue(accident)) {
            accidents.put(accident.getId(), accident);
        }
    }

    public void edit(Integer id, Accident accident) {
        if (accidents.containsKey(id)) {
            Accident accOld = accidents.get(accident.getId());
            accOld.setName(accident.getName());
            accOld.setText(accident.getText());
            accOld.setAddress(accident.getAddress());
        }
    }
}
