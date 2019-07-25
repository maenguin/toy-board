package maenguin.toyboard;

import maenguin.toyboard.controller.AccountController;
import maenguin.toyboard.controller.PostController;
import maenguin.toyboard.dto.account.AccountSaveDto;
import maenguin.toyboard.dto.post.PostSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;


@EnableJpaAuditing
@SpringBootApplication
public class ToyBoardApplication {


    /**
     *
     */
    @Autowired
    private AccountController accountController;
    @Autowired
    private PostController postController;

    public static void main(String[] args) {

        SpringApplication.run(ToyBoardApplication.class, args);


    }


    @PostConstruct
    public void testSet(){
        accountController.signUp(new AccountSaveDto("maenguin@gmail.com","1111"));
        postController.registerPost(new PostSaveDto("제목1","내용1","maenguin@gmail.com"));
        postController.registerPost(new PostSaveDto("제목2","내용2","maenguin@gmail.com"));
    }

}
