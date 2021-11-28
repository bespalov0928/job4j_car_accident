package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    public List<Accident> findAll();

    public Accident add(Accident accident);

}
