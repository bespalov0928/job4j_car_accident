package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Accident> findAllAccidents() {
        return jdbc.query("select accident.id as id, " +
                        "accident.name as name, " +
                        "accident.text as text, " +
                        "accident.address as address, " +
                        "accident.type as type " +
                        ",accidentType.id as typeId, " +
                        "accidentType.name as typeName " +
                        "from accident left join accidentType on accident.type = accidentType.id",
                (rs, row) -> {
                    AccidentType type = AccidentType.of(rs.getInt("typeId"), rs.getString("typeName"));
                    type.setId(rs.getInt("typeId"));
                    type.setName(rs.getString("typeName"));

                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    accident.setType(type);
                    return accident;
                }
        );
    }

    public Accident add(Accident accident) {
        jdbc.update("insert into  accident (name, text, address, type) values (?,?,?,?)",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId());
        return accident;
    }

    public Accident findById(int id) {
        Accident rsl;
        //jdbc.queryForObject("select * from accident where id = 1", new
        rsl = (Accident) jdbc.queryForObject("select accident.id as id, " +
                        "accident.name as name, " +
                        "accident.text as text, " +
                        "accident.address as address, " +
                        "accident.type as type, " +
                        "accidentType.id as typeId, " +
                        "accidentType.name as typeName " +
                        "from accident " +
                        "       left join accidentType " +
                        "         on accident.type = accidentType.id where accident.id = 1",
                (resultSet, rowNum) -> {
                    AccidentType type = new AccidentType();
                    type.setId(resultSet.getInt("typeId"));
                    type.setName(resultSet.getString("typeName"));

                    Accident newAccident = new Accident();
                    newAccident.setId(resultSet.getInt("id"));
                    newAccident.setName(resultSet.getString("name"));
                    newAccident.setText(resultSet.getString("text"));
                    newAccident.setAddress(resultSet.getString("address"));
                    newAccident.setType(type);
                    newAccident.setIdString(resultSet.getString("id"));
                    return newAccident;
                }
        );
        return rsl;
    }


    public ArrayList<AccidentType> findAllAccidentType() {
        List<AccidentType> types = jdbc.query(
                "select id, name from accidentType",
                (resultSet, rowNum) -> {
                    AccidentType type = new AccidentType();
                    type.setId(resultSet.getInt("id"));
                    type.setName(resultSet.getString("name"));
                    return type;
                });

        return (ArrayList<AccidentType>) types;
    }

    public AccidentType findByIdType(int id) {
        String sql = "select * from accidentType where id = ?";
        return (AccidentType) jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                AccidentType.of(rs.getInt("id"), rs.getString("name"))
        );

    }

    public List<Rule> findAllRule() {
        List<Rule> rules = jdbc.query(
                "select id, name from rule",
                (resultSet, rowNum) -> {
                    Rule rule = new Rule();
                    rule.setId(resultSet.getInt("id"));
                    rule.setName(resultSet.getString("name"));
                    return rule;
                });

        return (ArrayList<Rule>) rules;
    }

    public Rule findByIdRule(Integer id) {
        String sql = "select * from rule where id = ?";
        return (Rule) jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                Rule.of(rs.getInt("id"), rs.getString("name")));
    }

}

