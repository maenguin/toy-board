package maenguin.toyboard.controller;


import lombok.RequiredArgsConstructor;
import maenguin.toyboard.dto.post.PostDetailResDto;
import maenguin.toyboard.dto.post.PostEditReqDto;
import maenguin.toyboard.dto.post.PostReqDto;
import maenguin.toyboard.dto.post.PostSaveDto;
import maenguin.toyboard.dto.common.APIResDto;
import maenguin.toyboard.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class PostController {

    private final PostService postService;


    @PutMapping("/register")
    public ResponseEntity<APIResDto> registerPost (@RequestBody PostSaveDto postSaveDto) {
        boolean flag = postService.register(postSaveDto);
        return ResponseEntity.ok().body(APIResDto.of());
    }

    @GetMapping("/allposts")
    public ResponseEntity<APIResDto> findAllPosts () {
        return ResponseEntity.ok().body(APIResDto.of(postService.findAll()));
    }

    @GetMapping("")
    public ResponseEntity<APIResDto> findPost (@RequestParam("id") Long id) {
        PostDetailResDto postDetailResDto = postService.findById(new PostReqDto(id));
        return ResponseEntity.ok().body(APIResDto.of(postDetailResDto));
    }

    @PutMapping("Edit")
    public ResponseEntity<APIResDto> EditPost (@RequestBody PostEditReqDto postEditReqDto) {
        postService.EditPost(postEditReqDto);
        return ResponseEntity.ok().body(APIResDto.of());
    }


}
