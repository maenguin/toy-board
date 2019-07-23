package maenguin.toyboard.dto.account;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountSaveDto {

    private String email;
    private String password;

    public AccountSaveDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
