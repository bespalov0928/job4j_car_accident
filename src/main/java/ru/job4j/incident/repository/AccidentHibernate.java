package ru.job4j.incident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.incident.model.Accident;
import ru.job4j.incident.model.AccidentType;
import ru.job4j.incident.model.Rule;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Accident> findAllAccidents() {
        List rsl = null;
        try (Session session = sf.openSession()) {
            rsl = session.createQuery("from ru.job4j.incident.model.Accident").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public Accident add(Accident accident) {
        Accident rsl = null;
        try (Session session = sf.openSession()) {
            rsl = (Accident) session.save(accident);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;

    }

    public Accident findById(int id) {
        Accident rsl = null;
        try (Session session = sf.openSession()) {
            rsl = (Accident) session.createQuery("from ru.job4j.incident.model.Accident where id = :id"
            ).setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<AccidentType> findAllAccidentType() {
        List rsl = null;
        try (Session session = sf.openSession()) {
            rsl = session.createQuery("from ru.job4j.incident.model.AccidentType").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public AccidentType findByIdType(int id) {
        AccidentType rsl = null;
        try (Session session = sf.openSession()) {
            rsl = (AccidentType) session.createQuery("from ru.job4j.incident.model.AccidentType where id = :id"
            ).setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<Rule> findAllRule() {
        List rsl = null;
        try (Session session = sf.openSession()) {
            rsl = session.createQuery("from ru.job4j.incident.model.Rule").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public Rule findByIdRule(Integer id) {
        Rule rsl = null;
        try (Session session = sf.openSession()) {
            rsl = (Rule) session.createQuery("from ru.job4j.incident.model.Rule where id = :id"
            ).setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }


}
