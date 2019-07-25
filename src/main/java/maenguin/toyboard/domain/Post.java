package maenguin.toyboard.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maenguin.toyboard.dto.post.PostEditReqDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "POST")
@Entity
@NoArgsConstructor
public class Post extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "POST_TITLE")
    private String title;

    @NotEmpty
    @NotNull
    @Column(name = "POST_CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    @NotNull
    private Account account;


    @Builder
    public Post(@NotNull String title, @NotNull String content, @NotNull Account account) {
        this.title = title;
        this.content = content;
        this.account = account;
    }

    public void EditContent(@NotNull PostEditReqDto postEditReqDto ) {
        this.content = postEditReqDto.getContent();
    }
}
