package maenguin.toyboard.controller;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.dto.account.AccountSaveDto;
import maenguin.toyboard.dto.account.AccountSignInDto;
import maenguin.toyboard.dto.common.APIResDto;
import maenguin.toyboard.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/signUp")
    public ResponseEntity<APIResDto> signUp (@RequestBody AccountSaveDto accountSaveDto) {
        boolean flag = accountService.signUp(accountSaveDto);
        return ResponseEntity.ok().body(APIResDto.of());
    }

    @PostMapping("/signIn")
    public ResponseEntity<APIResDto> signIn (@RequestBody AccountSignInDto accountSignInDto) {
        boolean flag = accountService.signIn(accountSignInDto);
        return ResponseEntity.ok().body(APIResDto.of());
    }

}
