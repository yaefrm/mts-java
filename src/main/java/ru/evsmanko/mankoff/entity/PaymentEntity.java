package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long buyerId;
    private Integer MCCCode;
    private Double sum;
    private Timestamp timestamp;
}
