package ru.job4j.job4j_car_accident;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }


}
