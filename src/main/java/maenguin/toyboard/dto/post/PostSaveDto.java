package maenguin.toyboard.dto.post;


import lombok.Getter;
import maenguin.toyboard.domain.Account;
import maenguin.toyboard.domain.Post;

@Getter
public class PostSaveDto {

    private String title;
    private String content;
    private String author;

    public PostSaveDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity(Account account) {
        return  Post.builder()
                .title(title)
                .content(content)
                .account(account)
                .build();
    }
}
