package com.poleszak.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "customer_id_sequence")
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
