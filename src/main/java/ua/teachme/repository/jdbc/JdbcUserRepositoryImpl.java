package ua.teachme.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository{

    private static final BeanPropertyRowMapper<User> USER_PROPERTY_ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public JdbcUserRepositoryImpl(DataSource jdbcDataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(jdbcDataSource)
                                .withTableName("users")
                                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = jdbcTemplate.query("SELECT * FROM users JOIN accounts ON users.account_id = accounts.id WHERE accounts.email=?", USER_PROPERTY_ROW_MAPPER, email);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users JOIN accounts ON users.account_id = accounts.id ORDER BY name, registered_date_and_time", USER_PROPERTY_ROW_MAPPER);
    }

    @Override
    public User save(User entity) {
        MapSqlParameterSource parametersMap = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("password", entity.getPassword())
                .addValue("email", entity.getEmail())
                .addValue("maxHoursPerDay", entity.getMaxHoursPerDay())
                .addValue("registeredDateAndTime",entity.getRegisteredDateAndTime());
        if (entity.isNew()){
            Number newKey = jdbcInsert.executeAndReturnKey(parametersMap);
            entity.setId(newKey.intValue());
        }
        else {
            namedParameterJdbcTemplate.update(
                    "UPDATE users SET " +
                            "name=:name, " +
                            "password=:password, " +
                            "email=:email, " +
                            "max_hours_per_day=:maxHoursPerDay, " +
                            "registered_date_and_time=:registeredDateAndTime " +
                            "WHERE id=:id",
                    parametersMap);
        }
        return entity;
    }

    @Override
    public User get(int id) {
        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id=?", USER_PROPERTY_ROW_MAPPER, id);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
