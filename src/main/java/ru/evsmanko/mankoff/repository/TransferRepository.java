package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import ru.evsmanko.mankoff.entity.TransferEntity;
import java.util.ArrayList;

public interface TransferRepository extends CrudRepository<TransferEntity, Long> {
    ArrayList<TransferEntity> findAll();
    ArrayList<TransferEntity> findAllByIdSender( long idSender);
    TransferEntity save(TransferEntity transfer);

}
