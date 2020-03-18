package com.dy20c.test.springboot.service;

import com.dy20c.test.springboot.domain.posts.Posts;
import com.dy20c.test.springboot.domain.posts.PostsRepository;
import com.dy20c.test.springboot.dto.PostsResponseDto;
import com.dy20c.test.springboot.dto.PostsSaveRequestDto;
import com.dy20c.test.springboot.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. findById. id=" + id));

        return new PostsResponseDto(entity);
    }
}


/* 2020-03-18 (수) 오후 9:50 dy20c
* update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없습니다. 이게 가능한 이유는 JPA의 영속성 컨텍스트 때문입니다.
* 영속성, 컨텍스트란, 엔티티를 영구 저장하는 환경입니다. 일종의 논리적 개념이라고 보시면 되며, JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈립니다.
* JPA의 엔티티 매니저(entity manager)가 활성화된 상태로(Spring Data Jpa를 쓴다면 기본 옵션) 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태입니다.
* 이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영합니다. 즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다는 것이죠.
* 이 개념을 더티 체킹(dirty checking)이라고 합니다.
* 더티 체킹? https://jojoldu.tistory.com/415
* */