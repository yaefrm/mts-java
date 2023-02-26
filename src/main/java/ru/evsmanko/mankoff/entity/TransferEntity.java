package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transfers")
public class TransferEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long idSender;
    private Long idReceiver;
    private Double amount;
    private Timestamp timestamp;
}
