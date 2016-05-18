package ua.teachme.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ua.teachme.model.Notation;
import ua.teachme.model.User;
import ua.teachme.repository.NotationRepository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcNotationRepositoryImpl implements NotationRepository{

/*
    private static final BeanPropertyRowMapper<Notation> NOTATION_PROPERTY_ROW_MAPPER = BeanPropertyRowMapper.newInstance(Notation.class);
*/

    private static final RowMapper<Notation> NOTATION_PROPERTY_ROW_MAPPER_TIMESTAMP = (rowSet, rowNum) ->
            new Notation(
                    rowSet.getInt("id"),
                    rowSet.getString("name"),
                    rowSet.getString("url"),
                    rowSet.getString("description"),
                    rowSet.getInt("hours"),
                    rowSet.getTimestamp("created_date_and_time").toLocalDateTime()
            );

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert jdbcInsertNotation;

    @Autowired
    public JdbcNotationRepositoryImpl(DataSource jdbcDataSource){
        this.jdbcInsertNotation = new SimpleJdbcInsert(jdbcDataSource)
                                        .withTableName("notations")
                                        .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return jdbcTemplate.query(
                "SELECT * FROM notations WHERE created_date_and_time BETWEEN ? AND ? ORDER BY created_date_and_time DESC",
                NOTATION_PROPERTY_ROW_MAPPER_TIMESTAMP,
                Timestamp.valueOf(start),
                Timestamp.valueOf(end)
        );
    }

    @Override
    public List<Notation> getAll() {
        return jdbcTemplate.query("SELECT * FROM notations ORDER BY name, created_date_and_time", NOTATION_PROPERTY_ROW_MAPPER_TIMESTAMP);
    }

    @Override
    public Notation save(Notation entity) {
        MapSqlParameterSource parametersMap = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("url", entity.getUrl())
                .addValue("description", entity.getDescription())
                .addValue("hours", entity.getHours())
                .addValue("createdDateAndTime", Timestamp.valueOf(entity.getCreatedDateAndTime()));

        if (entity.isNew()){
            Number newKey = jdbcInsertNotation.executeAndReturnKey(parametersMap);
            entity.setId(newKey.intValue());
        }
        else {
            namedParameterJdbcTemplate.update(
                    "UPDATE notations SET " +
                            "name=:name, " +
                            "url=:url, " +
                            "description=:description, " +
                            "hours=:hours, " +
                            "created_date_and_time=:createdDateAndTime " +
                            "WHERE id=:id",
                    parametersMap);
        }
        return entity;
    }

    @Override
    public Notation get(int id) {
        List<Notation> notations = jdbcTemplate.query("SELECT * FROM notations WHERE id=?", NOTATION_PROPERTY_ROW_MAPPER_TIMESTAMP, id);
        return DataAccessUtils.singleResult(notations);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM notations WHERE id=?", id);
    }
}