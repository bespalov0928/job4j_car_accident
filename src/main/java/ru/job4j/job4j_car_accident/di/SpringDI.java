package ru.job4j.job4j_car_accident.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.job4j_car_accident.ConsoleInput;
import ru.job4j.job4j_car_accident.StartUI;
import ru.job4j.job4j_car_accident.Store;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();

    }

}
