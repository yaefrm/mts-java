package ru.evsmanko.mankoff.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.PaymentEntity;

import java.util.List;

@Repository
public class PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_SELECT_ALL = "SELECT * FROM PAYMENTS";

    private static final String SQL_SELECT_ALL_BY_BUYER_ID = "SELECT * FROM PAYMENTS WHERE BUYER_ID = ?";

    private static final String SQL_INSERT = "INSERT INTO PAYMENTS (BUYER_ID, MCCCODE, SUM, TIMESTAMP) VALUES (?, ?, ?, ?)";

    @Autowired
    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PaymentEntity> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new BeanPropertyRowMapper<>(PaymentEntity.class));
    }

    public List<PaymentEntity> findPaymentEntitiesByBuyerId(long buyerId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_BUYER_ID, new BeanPropertyRowMapper<>(PaymentEntity.class), buyerId);
    }

    public PaymentEntity save(PaymentEntity payment) {
        jdbcTemplate.update(
                SQL_INSERT,
                payment.getBuyerId(),
                payment.getMCCCode(),
                payment.getSum(),
                payment.getTimestamp().toString());

        return payment;
    }
}
