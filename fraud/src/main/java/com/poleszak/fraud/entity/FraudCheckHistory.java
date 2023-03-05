package com.poleszak.fraud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FraudCheckHistory {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "fraud_id_sequence")
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
