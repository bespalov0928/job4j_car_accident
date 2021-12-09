package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {

    @Query("select distinct a from Rule")
    public List<Rule> findAll();


}
