package org.sid.Atelier2.mappers;

import org.sid.Atelier2.dto.BankAccountResponseDTO;
import org.sid.Atelier2.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO); //on prend les donner de bank account et les transfer a bankaccountdto
        return bankAccountResponseDTO;
    }
}
