package maenguin.toyboard.dto.post;


import lombok.Getter;

@Getter
public class PostReqDto {

    private Long Id;

    public PostReqDto(Long id) {
        Id = id;
    }
}
