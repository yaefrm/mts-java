package ru.evsmanko.mankoff.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserEntityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SQL_SELECT_ALL = "SELECT * FROM user_entities";

    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_entities WHERE id = ?";

    private final String SQL_INSERT = "INSERT INTO user_entities (first_name, last_name, age, city) VALUES (?, ?, ?, ?)";

    private UserEntity mapRowToUserEntity(ResultSet rs, int rowNum) throws SQLException {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(rs.getLong("id"));
        userEntity.setFirstName(rs.getString("first_name"));
        userEntity.setLastName(rs.getString("last_name"));
        userEntity.setAge(rs.getInt("age"));
        userEntity.setCity(rs.getString("city"));

        return userEntity;
    }

    public List<UserEntity> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, this::mapRowToUserEntity);
    }

    public Optional<UserEntity> getUserEntityById(long id) {
        List<UserEntity> result = jdbcTemplate.query(SQL_SELECT_BY_ID, this::mapRowToUserEntity, id);
        return result.size() > 0 ? Optional.of(result.get(0)) : Optional.empty();
    }

    public Optional<UserEntity> save(UserEntity user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int affectedRowNumber = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT, new String[]{"id"});

                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setInt(3, user.getAge());
                preparedStatement.setString(4, user.getCity());

                return preparedStatement;
            }
        }, keyHolder);

        if (affectedRowNumber == 0 || keyHolder.getKey() == null) {
            return Optional.empty();
        }

        return this.getUserEntityById(keyHolder.getKey().longValue());
    }
}
