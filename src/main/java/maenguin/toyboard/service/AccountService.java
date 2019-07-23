package maenguin.toyboard.service;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.domain.Account;
import maenguin.toyboard.dto.account.AccountSaveDto;
import maenguin.toyboard.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public boolean signUp(AccountSaveDto accountSaveDto) {

        if (accountRepository.findByEmail(accountSaveDto.getEmail()).isPresent()){
            return false;
        }
        Account account = new Account(accountSaveDto.getEmail(),accountSaveDto.getPassword());
        accountRepository.save(account);
        return true;

    }

}
