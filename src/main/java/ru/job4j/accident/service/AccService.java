package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;

import java.util.List;

//@Service
public interface AccService {

    public ArrayList<Accident> findAllAccidents();

    public void add(Accident accident, String[] rIds);

    public Accident findById(int id);


    public List<AccidentType> findAllAccidentType();


    public AccidentType findByIdType(int id);


    public List<Rule> findAllRule();


}
