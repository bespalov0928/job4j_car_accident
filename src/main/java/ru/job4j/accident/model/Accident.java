package ru.job4j.accident.model;

import java.util.HashSet;
import java.util.Set;

public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private Set<Rule> rules;

    public Accident() {
    }

    public static Accident of(String name, String text, String address, AccidentType type) {
        Accident acc  = new Accident();
        acc.name = name;
        acc.text = text;
        acc.address = address;
        acc.type = type;
        return acc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getAddress() {
        return address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void addRule(Rule rule) {
        if (this.rules == null) {
            this.rules = new HashSet<Rule>();
        }
        this.rules.add(rule);
    }
}
