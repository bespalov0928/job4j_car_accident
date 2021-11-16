package ru.job4j.incident.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;

    @OneToOne
    private AccidentType type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rule> rules;

    public static Accident of(String name, String text, String address, AccidentType type) {
        Accident acc = new Accident();
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Accident accident = (Accident) obj;
        return id == accident.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
