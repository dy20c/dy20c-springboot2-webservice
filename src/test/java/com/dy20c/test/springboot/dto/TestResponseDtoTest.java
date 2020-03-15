package com.dy20c.test.springboot.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TestResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 2020;

        //when
        TestResponseDto dto = new TestResponseDto(name, amount);

        //then
        /*
        * 2020.03.14 (토) 오후 8:09 Reference#1
        * (1) assertThat
        *       - assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
        *       - 검증하고 싶은 대상을 메소드 인자로 받습니다.
        *       - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
        * (2) isEqualTo
        *       - assertj의 동등 비교 메소드입니다.
        *       - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.
        */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/*
 * Reference#1
 * 스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱 지음, 프리렉
 *
 * JUnit과 assertj, 왜 JUnit의 assertThat이 아닌 assertj의 assertThat을 사용했나?
 *  (1) CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않습니다.
 *      - JUnit의 assertThat을 쓰게 되면 is()와 같이 CoreMatchers 라이브러리가 필요합니다.
 *  (2) 자동완성이 좀 더 확실하게 지원됩니다.
 *      - IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약합니다.
 *  assertj의 장점에 대한 자세한 설명은 백기선님의 유튜브 'assertJ가 JUnit의 assertThat 보다 편리한 이유'를 참고하면 좋습니다(https://bit.ly/30vm9Lg)
 *
 */