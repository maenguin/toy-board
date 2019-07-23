package maenguin.toyboard.controller;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.dto.account.AccountSaveDto;
import maenguin.toyboard.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/signUp")
    public ResponseEntity<Boolean> signUp (@RequestBody AccountSaveDto accountSaveDto) {
        boolean flag = accountService.signUp(accountSaveDto);
        return ResponseEntity.ok().body(flag);
    }


}
