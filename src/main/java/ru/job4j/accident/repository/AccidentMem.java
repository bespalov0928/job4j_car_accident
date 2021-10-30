package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.controller.IndexControl;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentService;

import java.util.*;

@Repository
public class AccidentMem {

    private static AccidentMem instance;
    private final AccidentService accidentService = AccidentService.getInstance();
    private Map<Integer, Accident> accidents = new HashMap<>();
    private Map<Integer, AccidentType> types = new HashMap<>();

    private AccidentMem() {

        if (accidents.size() == 0) {

            AccidentType type1 = AccidentType.of(1, "Две машины");
            AccidentType type2 = AccidentType.of(2, "Машина и человек");
            AccidentType type3 = AccidentType.of(3, "Машина и велосипед");
            types.put(type1.getId(), type1);
            types.put(type2.getId(), type2);
            types.put(type3.getId(), type3);

            Accident acc1 = accidentService.createAccident("acc1", "descr1", "addres1", type1);
            Accident acc2 = accidentService.createAccident("acc2", "descr2", "addres2", type2);
            Accident acc3 = accidentService.createAccident("acc3", "descr3", "addres3", type3);
            accidents.put(acc1.getId(), acc1);
            accidents.put(acc2.getId(), acc2);
            accidents.put(acc3.getId(), acc3);
        }
    }

    public static AccidentMem getInstance() {

        if (instance == null) {
            instance = new AccidentMem();
        }
        return instance;

    }

    public ArrayList<Accident> findAllAccidents() {
        Collection<Accident> colRsl = accidents.values();
        ArrayList rsl = new ArrayList(colRsl);
        return rsl;
    }

    public void add(Accident accident) {
        if (accident.getId() == 0) {
            accidentService.generateId(accident);
        } else {
            accident.setId(Integer.valueOf(accident.getIdString()));
        }
        accident.setType(findByIdType(accident.getType().getId()));
        if (!accidents.containsValue(accident)) {
            accidents.put(accident.getId(), accident);
        }
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

}
