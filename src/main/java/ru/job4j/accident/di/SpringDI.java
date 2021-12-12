package ru.job4j.accident.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.accident.leson.ConsoleInput;
import ru.job4j.accident.leson.StartUI;
import ru.job4j.accident.leson.Store;

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
