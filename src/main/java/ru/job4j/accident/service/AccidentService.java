package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Random;

@Service
public class AccidentService {
    final Random random = new Random();

    public Accident createAccident(String name, String descr, String addres) {
        Accident acc = new Accident(name, descr, addres);
        acc.setId(random.nextInt(100));
        return acc;
    }

}
