package ua.teachme.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
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

    private static final BeanPropertyRowMapper<User> ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    public JdbcUserRepositoryImpl(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                                .withTableName("users")
                                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User getByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", ROW_MAPPER, email);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name, email", ROW_MAPPER);
    }

    @Override
    public User save(User entity) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("password", entity.getPassword())
                .addValue("email", entity.getEmail())
                .addValue("max_hours_per_day", entity.getMaxHoursPerDay())
                .addValue("registered_date", entity.getRegisteredDate());

        if (entity.isNew()){
            Number newKey = jdbcInsert.executeAndReturnKey(map);
            entity.setId(newKey.intValue());
        }
        else {
            namedParameterJdbcTemplate.update(
                    "UPDATE users SET " +
                            "name=:name, " +
                            "password=:password, " +
                            "email=:email, " +
                            "max_hours_per_day=:caloriesPerDay, " +
                            "registered=:registeredDate " +
                            "WHERE id=:id",
                    map);

        }
        return entity;
    }

    @Override
    public User get(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", ROW_MAPPER, id).get(0);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.execute("DELETE FROM users WHERE id=?");
    }
}
