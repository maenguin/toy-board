package maenguin.toyboard.service;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.domain.Account;
import maenguin.toyboard.dto.account.AccountSaveDto;
import maenguin.toyboard.dto.account.AccountSignInDto;
import maenguin.toyboard.enums.ErrorCode;
import maenguin.toyboard.exception.business.BusinessException;
import maenguin.toyboard.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public boolean signUp(final AccountSaveDto accountSaveDto) {

        if (accountRepository.findByEmail(accountSaveDto.getEmail()).isPresent()){
            throw new BusinessException(ErrorCode.EMAIL_DUPLICATION);
        }
        accountRepository.save(accountSaveDto.toEntity());
        return true;

    }

    @Transactional
    public boolean signIn(final AccountSignInDto accountSignInDto) {

        Account account = accountRepository.findByEmail(accountSignInDto.getEmail()).orElseThrow(() ->new BusinessException(ErrorCode.EMAIL_OR_PASS_NOT_MATCHED));

        if (!account.getPassword().equals(accountSignInDto.getPassword())) {
            throw new BusinessException(ErrorCode.EMAIL_OR_PASS_NOT_MATCHED);
        }
        return true;
    }

}
