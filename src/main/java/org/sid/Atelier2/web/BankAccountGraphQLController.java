package org.sid.Atelier2.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.Atelier2.dto.BankAccountRequestDTO;
import org.sid.Atelier2.dto.BankAccountResponseDTO;
import org.sid.Atelier2.entities.BankAccount;
import org.sid.Atelier2.entities.Customer;
import org.sid.Atelier2.repositories.BankAccountRepository;
import org.sid.Atelier2.repositories.CustomerRepository;
import org.sid.Atelier2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class  BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping //quand le client demande accountList dans le schema il va automatiquement executer la accountList(meme nom)
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping //quand le client demande accountList dans le schema il va automatiquement executer la accountList(meme nom)
    public BankAccount BankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found" , id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
/*
record BankAccountDTO(Float Balance,String type,String currency){
} //record c'est lequivalent d'une creation dune classe avec les getters et setters et constr
*/

