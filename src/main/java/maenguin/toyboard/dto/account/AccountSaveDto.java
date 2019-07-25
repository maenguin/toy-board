package maenguin.toyboard.dto.account;


import lombok.Getter;
import lombok.NoArgsConstructor;
import maenguin.toyboard.domain.Account;

@Getter
@NoArgsConstructor
public class AccountSaveDto {

    private String email;
    private String password;

    public AccountSaveDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account toEntity() {
        return Account.builder()
                .email(email)
                .password(password)
                .build();
    }
}
