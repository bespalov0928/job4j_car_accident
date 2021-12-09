package ru.job4j.accident.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("select distinct a from Accident as a join fetch a.rules join fetch a.type")
    public List<Accident> findAll();

    @Query("select distinct a from Accident as a  join fetch a.rules join fetch a.type where a.id = :id")
    public Accident findById(int id);

    public Accident save(Accident accident);
}
