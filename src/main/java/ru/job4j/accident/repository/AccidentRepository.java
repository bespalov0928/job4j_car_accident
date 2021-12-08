package ru.job4j.accident.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;


public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("select distinct a from Accident as a join fetch a.rules join fetch a.type")
    public List<Accident> findAll();

    @Query("select distinct a from Accident as a  join fetch a.rules join fetch a.type where a.id = :id")
    public Accident findById(int id);

    public Accident save(Accident accident);


    @Query("select distinct a from AccidentType")
    public List<AccidentType> findAllAccidentType();

    @Query("select distinct a from AccidentType as a where a.id = :id")
    public AccidentType findByIdType(int id);


    @Query("select distinct a from Rule")
    public List<Rule> findAllRule();

}
