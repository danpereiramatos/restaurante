package br.com.nomeempresa.restaurante.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "customer")
@Entity
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column( name = "name",length=50)
    private String name;

    @Column( name = "cpf",unique=true,length=11)
    private String cpf;

    @Column( name = "email",length=50)
    private String email;

}
