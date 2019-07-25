package maenguin.toyboard.service;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.domain.Account;
import maenguin.toyboard.domain.Post;
import maenguin.toyboard.dto.post.*;
import maenguin.toyboard.enums.ErrorCode;
import maenguin.toyboard.exception.business.BusinessException;
import maenguin.toyboard.repository.AccountRepository;
import maenguin.toyboard.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public boolean register(final PostSaveDto postSaveDto) {

        Account account = accountRepository.findByEmail(postSaveDto.getAuthor()).orElseThrow(() -> new BusinessException(ErrorCode.EMAIL_NOT_FOUND));
        postRepository.save(postSaveDto.toEntity(account));
        return true;
    }

    @Transactional
    public List<PostResDto> findAll() {

        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new BusinessException(ErrorCode.POST_NOT_FOUND);
        }

        List<PostResDto> collect = posts
                                        .stream()
                                        .map(post -> new PostResDto(post))
                                        .collect(Collectors.toList());

        return collect;
    }

    @Transactional
    public PostDetailResDto findById(final PostReqDto postReqDto) {

        Post post = postRepository.findById(postReqDto.getId()).orElseThrow(() -> new BusinessException(ErrorCode.POST_DELETED));
        return new PostDetailResDto(post);
    }

    @Transactional
    public boolean EditPost(final PostEditReqDto postEditReqDto) {
        Post post = postRepository.findById(postEditReqDto.getId()).orElseThrow(() -> new BusinessException(ErrorCode.POST_DELETED));
        post.EditContent(postEditReqDto);
        return true;
    }


}
