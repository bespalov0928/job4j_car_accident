package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;


public class AccidentHibernate {
    private AtomicInteger counter = new AtomicInteger(0);
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    private <T> T tx(final Function<Session, T> comand) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = comand.apply(session);
            tx.commit();
            session.close();
            return rsl;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }


    public List<Accident> findAllAccidents() {
        return this.tx(session -> {
            List<Accident> rsl = session.createQuery("from ru.job4j.accident.model.Accident").list();
            return rsl;
        });
    }

    public Accident add(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(counter.incrementAndGet());
        }

        return this.tx(session -> {
            session.save(accident);
            return accident;
        });

    }

    public Accident findById(int id) {
        return this.tx(session -> {
            Accident rsl = (Accident) session.createQuery("from ru.job4j.accident.model.Accident where id = :id"
            ).setParameter("id", id).uniqueResult();
            return rsl;
        });
    }

    public List<AccidentType> findAllAccidentType() {
        return this.tx(session -> {
            List<AccidentType> rsl = session.createQuery("from ru.job4j.accident.model.AccidentType").list();
            return rsl;
        });
    }

    public AccidentType findByIdType(int id) {
        return this.tx(session -> {
            AccidentType rsl = (AccidentType) session.createQuery("from ru.job4j.accident.model.AccidentType where id = :id"
            ).setParameter("id", id).uniqueResult();
            return rsl;
        });
    }

    public List<Rule> findAllRule() {
        return this.tx(session -> {
            List<Rule> rsl = session.createQuery("from ru.job4j.accident.model.Rule").list();
            return rsl;
        });
    }

    public Rule findByIdRule(Integer id) {
        return this.tx(session -> {
            Rule rsl = (Rule) session.createQuery("from ru.job4j.accident.model.Rule where id = :id"
            ).setParameter("id", id).uniqueResult();
            return rsl;
        });
    }


}
