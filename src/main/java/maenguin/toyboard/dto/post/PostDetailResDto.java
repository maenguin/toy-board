package maenguin.toyboard.dto.post;


import lombok.Getter;
import maenguin.toyboard.domain.Post;
import maenguin.toyboard.dto.common.ResponseDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class PostDetailResDto implements ResponseDto {


    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime date;

    public PostDetailResDto(@NotNull Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAccount().getEmail();
        this.date = post.getLastModifiedDate();
    }
}
