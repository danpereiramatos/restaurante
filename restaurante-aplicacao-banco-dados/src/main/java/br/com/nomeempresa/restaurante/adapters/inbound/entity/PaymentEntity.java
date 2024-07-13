package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "PAYMENT")
@Entity
@Getter
@Setter
public class PaymentEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "payer")
    private String payer;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "product", nullable = false)
    private ProdutoEntity product;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}
