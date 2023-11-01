package org.sid.Atelier2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//ca concerne rest pour que lors de laffichage avec rest on aura pas une boucle client a un compte le compte a un client ..
    private List<BankAccount> bankAccounts;
}
