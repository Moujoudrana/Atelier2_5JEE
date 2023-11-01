package org.sid.Atelier2.web;

import org.sid.Atelier2.dto.BankAccountRequestDTO;
import org.sid.Atelier2.dto.BankAccountResponseDTO;
import org.sid.Atelier2.entities.BankAccount;
import org.sid.Atelier2.mappers.AccountMapper;
import org.sid.Atelier2.repositories.BankAccountRepository;
import org.sid.Atelier2.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api") //pou acceder il faut ecrire /api/leschemins
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(
                String.format("Account not found", id)));
    }
    /*
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){ //recuperation des donnees dans le corps de la requete
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());//pour generer lid si jamais lid nest pas donné
        return bankAccountRepository.save(bankAccount);
    }
    */
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){ //recuperation des donnees dans le corps de la requete
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}") //mise a j dun compte qui existe deja
    public BankAccount save(@PathVariable String id,@RequestBody BankAccount bankAccount){ //recuperation des donnees dans le corps de la requete
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());//si on ne fait pas le if et les valeurs de quelque champ n'ont pas ete donner il va les ecraser
        if(bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }

}
