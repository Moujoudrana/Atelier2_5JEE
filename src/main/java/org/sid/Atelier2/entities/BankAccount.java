package org.sid.Atelier2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.Atelier2.enums.AccountType;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //design pattern pour creer les objets
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING) //pour que la valeur ne se stock pas en base de donnée format numerique par defaut cest ordinal
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
