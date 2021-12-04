package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("select accident.id as id, accident.name as name, accident.text as text, accident.address as address, accident.type as type ,accidentType.id as typeId, accidentType.name as typeName from accident left join accidentType on accident.type = accidentType.id")
    public List<Accident> findAll();

    public Accident findById(int id);

    public Accident save(Accident accident);


    @Query("select id, name from accidentType")
    public List<AccidentType> findAllAccidentType();

    @Query("select id, name from accidentType where id = ?1")
    public Accident findByIdType(int id);


    @Query("select id, name from rule")
    public List<Rule> findAllRule();

    @Query("select id, name from rule where id = ?1")
    public Rule findByIdRule(int id);


}
