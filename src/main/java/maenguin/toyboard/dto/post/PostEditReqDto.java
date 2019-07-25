package maenguin.toyboard.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import maenguin.toyboard.domain.Post;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class PostEditReqDto {

    private Long id;
    private String content;

    public PostEditReqDto(@NotNull Post post) {
        this.id = post.getId();
        this.content = post.getContent();
    }
}
