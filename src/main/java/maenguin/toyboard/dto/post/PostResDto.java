package maenguin.toyboard.dto.post;


import lombok.Getter;
import maenguin.toyboard.domain.Post;
import maenguin.toyboard.dto.common.ResponseDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class PostResDto implements ResponseDto {


    private Long id;
    private String title;
    private String author;
    private LocalDateTime date;

    public PostResDto(@NotNull Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAccount().getEmail();
        this.date = post.getLastModifiedDate();
    }

}
