package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;
import java.util.List;

@Service
public class AccidentServiceSpringData {
    private final AccidentRepository accRepository;
    private final AccidentTypeRepository accTypeRepository;
    private final RuleRepository ruleRepository;


    public AccidentServiceSpringData(AccidentRepository accRepository, AccidentTypeRepository accTypeRepository, RuleRepository ruleRepository) {
        this.accRepository = accRepository;
        this.accTypeRepository = accTypeRepository;
        this.ruleRepository = ruleRepository;
    }

    public List<Accident> findAllAccidents() {
        List<Accident> rsl = accRepository.findAll();
        return rsl;
    }

    public void add(Accident accident) {
        accRepository.save(accident);
    }

    public Accident findById(int id) {
        Accident acc = accRepository.findById(id);
        return acc;
    }

    public List<AccidentType> findAllAccidentType() {
        List<AccidentType> rsl = (List<AccidentType>) accTypeRepository.findAll();
        return rsl;
    }

    public List<Rule> findAllRule() {
        List<Rule> rsl = (List<Rule>) ruleRepository.findAll();
        return rsl;
    }


}