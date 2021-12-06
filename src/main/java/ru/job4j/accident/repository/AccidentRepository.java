package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    private EntityManagerFactory EMF = null;

    public AccidentRepository(){
        Map properties = new HashMap();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        EMF = Persistence.createEntityManagerFactory("entity-graph-pu", properties);

    }

    public List<Accident> findAllAccident(){
        EntityManager entityManager = EMF.createEntityManager();
        EntityGraph entityGraph = entityManager.getEntityGraph("accident-entity-graph");
        List<Accident> rsl = entityManager.createQuery("Select a from Accident a", Accident)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
        return rsl;

    }
    public List<Accident> findAll();

    public Accident findById(int id);

    public Accident save(Accident accident);



}
