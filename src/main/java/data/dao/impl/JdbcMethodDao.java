package data.dao.impl;

import data.dto.Method;
import data.dao.MethodDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcMethodDao implements MethodDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource (DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addMethod(Method method) {
        this.jdbcTemplate.update(
                "insert into method(method_id, name, title, notation, stage, classification, lengthOfLead, numberOfHunts, leadHead, leadHeadCode, symmetry, notes) values (?,?,?,?,?,?,?,?,?,?,?,?)",
                method.getID(), method.getName(), method.getTitle(), method.getNotation(), method.getStage(), method.getClassification(), method.getLengthOfLead(), method.getNumberOfHunts(), method.getLeadHead(), method.getLeadHeadCode(), method.getSymmetry(), method.getNotes()
        );
    }

    @Override
    public Set<Method> getAllMethod() {
        final List<Method> results = this.jdbcTemplate.query("select * from method",
                new BeanPropertyRowMapper<>(Method.class));

        return new HashSet<>(results);
    }
}
