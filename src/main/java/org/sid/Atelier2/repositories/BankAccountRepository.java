package org.sid.Atelier2.repositories;

import org.sid.Atelier2.entities.BankAccount;
import org.sid.Atelier2.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //on demande a spring au demarrage demarre un webservice restful qui permet de gerer une entite de type bankanccount(donc les get post pull) se cree par defaut du controleur //grace a la dependance de rest ajoutee dans pom
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path="/byType")
    List<BankAccount> findByType(@Param("t") AccountType type); //nouvelle methode mais sans creer dans le controleur qui fait sont appel avec rest cest autmatique en utilisant /banAccount/search/nommethode(findbytype)? nomduparam(type)=parametre(SAVING_ACCOUNT)
    //mnt grace au annotation on appelle la methode pas par son nom mais par bytype te la parametre pas par type mais t
    //ca devient localhost:8081/bankAccounts/search/byType?t=SAVING_ACCOUNT
}
