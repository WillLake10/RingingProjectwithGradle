package data.dao.impl;

import data.dto.Method;
import data.dao.MethodDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcMethodDao implements MethodDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    public void addMethod(Method method) {
        this.jdbcTemplate.update(
                "insert into method(CCCBRID, name, title, notation, stage, classification, lengthOfLead, numberOfHunts, leadHead, leadHeadCode, symmetry, notes) values (?,?,?,?,?,?,?,?,?,?,?,?)",
                method.getCCCBRID(), method.getName(), method.getTitle(), method.getNotation(), method.getStage(), method.getClassification(), method.getLengthOfLead(), method.getNumberOfHunts(), method.getLeadHead(), method.getLeadHeadCode(), method.getSymmetry(), method.getNotes()
        );
        log.info(method.toString() + " added to 'method' table");
    }

    @Override
    public Set<Method> getAllMethod() {
        final List<Method> results = this.jdbcTemplate.query("select * from method",
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(results);
    }

    @Override
    public Set<Method> fullFieldSearch(String searchTerm) {
        final List<Method> result = this.jdbcTemplate.query("select * from method " +
                        "where lower(name) like '%' || lower(?) || '%' or " +
                        "lower(title) like '%' || lower(?) || '%' or " +
                        "lower(notation) like '%' || lower(?) || '%' or " +
                        "lower(stage) like '%' || lower(?) || '%' or " +
                        "lower(classification) like '%' || lower(?) || '%' or " +
                        "lower(lengthOfLead) like '%' || lower(?) || '%' or " +
                        "lower(numberOfHunts) like '%' || lower(?) || '%' or " +
                        "lower(leadHead) like '%' || lower(?) || '%' or " +
                        "lower(leadHeadCode) like '%' || lower(?) || '%' or " +
                        "lower(symmetry) like '%' || lower(?) || '%' or " +
                        "lower(notes) like '%' || lower(?) || '%'",
                new Object[]{searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

    @Override
    public Set<Method> getMethodsForStage(int stage) {
        final List<Method> result = this.jdbcTemplate.query("select * from method " +
                        "where lower(stage) like '%' || lower(?) || '%'",
                new Object[]{stage},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

    @Override
    public Set<Method> getMethodsForStageAndName(String name, int stage) {
        final List<Method> result = this.jdbcTemplate.query("select * from method " +
                        "where lower(stage) like '%' || lower(?) || '%' and " +
                        "(lower(title) like '%' || lower(?) || '%' or " +
                        "lower(name) like '%' || lower(?) || '%')",
                new Object[]{stage, name, name},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

    @Override
    public Set<Method> getMethodsForName(String name) {
        final List<Method> result = this.jdbcTemplate.query("select * from method " +
                        "where lower(title) like '%' || lower(?) || '%'",
                new Object[]{name},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

}
