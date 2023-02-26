package ru.evsmanko.mankoff.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.TransferEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TransferRepository {
    private static final String QUERY_FINDALL = "SELECT * FROM transfers";
    private static final String QUERY_FINDAll_BY_IDSENDER = "SELECT * FROM transfers WHERE id_sender = ?";
    private static final String QUERY_SAVE = "insert into TransferEntity(id, idSender, idReceiver, amount, timestamp) values (?,?,?)";
    private final JdbcTemplate jdbcTemplate;

    public TransferEntity mapRowToTransferEntity(ResultSet rs, int rowNum) throws SQLException {
        TransferEntity transfer = new TransferEntity();
        transfer.setId(rs.getLong("id"));
        transfer.setIdSender(rs.getLong("id_sender"));
        transfer.setIdReceiver(rs.getLong("id_receiver"));
        transfer.setAmount(rs.getDouble(    "amount"));
        transfer.setTimestamp(rs.getTimestamp("timestamp"));
        return transfer;
    }

    public Iterable<TransferEntity> findAll(){
        return jdbcTemplate.query(QUERY_FINDALL, this::mapRowToTransferEntity);
    }

    public Optional<TransferEntity> findAllByIdSender (Long idSender){
        List<TransferEntity> results = jdbcTemplate.query(QUERY_FINDAll_BY_IDSENDER,this::mapRowToTransferEntity, idSender);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    public TransferEntity save(TransferEntity transfer){
        jdbcTemplate.update(
                QUERY_SAVE,
                transfer.getId(),
                transfer.getIdSender(),
                transfer.getIdReceiver(),
                transfer.getTimestamp()
        );
        return transfer;
    }
}
