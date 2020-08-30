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

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addMethod(Method method) {
        this.jdbcTemplate.update(
                "insert into method(methodId, name, title, notation, stage, classification, lengthOfLead, numberOfHunts, leadHead, leadHeadCode, symmetry, notes) values (?,?,?,?,?,?,?,?,?,?,?,?)",
                method.getMethodId(), method.getName(), method.getTitle(), method.getNotation(), method.getStage(), method.getClassification(), method.getLengthOfLead(), method.getNumberOfHunts(), method.getLeadHead(), method.getLeadHeadCode(), method.getSymmetry(), method.getNotes()
        );
        log.info(method.toString() + " addded to 'method' table");
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
                new Object[] {searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm, searchTerm},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

    @Override
    public Set<Method> getMethodsForStage(int stage) {
        final List<Method> result = this.jdbcTemplate.query("select * from method " +
                        "where lower(stage) like '%' || lower(?) || '%'",
                new Object[] {stage},
                new BeanPropertyRowMapper<>(Method.class));
        return new HashSet<>(result);
    }

}
