package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccidentService {
    private AtomicInteger counter = new AtomicInteger(0);

    public Accident createAccident(String name, String descr, String addres) {
        Accident acc = new Accident(name, descr, addres);
        acc.setId(counter.incrementAndGet());
        return acc;
    }

}
