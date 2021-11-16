package ru.job4j.incident.service;

import org.springframework.stereotype.Service;
import ru.job4j.incident.model.Accident;
import ru.job4j.incident.model.AccidentType;
import ru.job4j.incident.model.Rule;

import java.util.ArrayList;

import java.util.List;

@Service
public interface AccService {

    public ArrayList<Accident> findAllAccidents();

    public void add(Accident accident, String[] rIds);

    public Accident findById(int id);


    public List<AccidentType> findAllAccidentType();


    public AccidentType findByIdType(int id);


    public List<Rule> findAllRule();


}
