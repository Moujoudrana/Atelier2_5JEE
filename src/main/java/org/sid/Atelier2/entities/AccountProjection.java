package org.sid.Atelier2.entities;

import org.sid.Atelier2.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;
//classe qui nous donne la possibilité de retourner seulement les attributs qu'on veut lorsquon appelle sur localhost
//parec que rest affiche tout les attributs. et il est possible de creer plusieurs projection
//localhost:8081/bankAccounts?projection=p1
@Projection(types= BankAccount.class, name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
