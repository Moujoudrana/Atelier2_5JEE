package org.sid.Atelier2.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.Atelier2.enums.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//pour creer un compte on a pas besoin de donner lid ni la date
public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;
}
