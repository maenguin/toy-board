package maenguin.toyboard.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "ACCOUNT")
@Entity
@Getter
@NoArgsConstructor
public class Account {


    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACCOUNT_EAMIL",unique = true)
    @NotNull
    private String email;

    @Column(name = "ACCOUNT_PASSWORD")
    @NotNull
    private String password;

    public Account(@NotNull @Email String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }
}
