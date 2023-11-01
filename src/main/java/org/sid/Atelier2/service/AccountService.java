package org.sid.Atelier2.service;

import org.sid.Atelier2.dto.BankAccountRequestDTO;
import org.sid.Atelier2.dto.BankAccountResponseDTO;
import org.sid.Atelier2.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
