package com.dy20c.test.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 2020.03.14 (토) 오후 10:26 Reference#1 @Getter, (1) 선언된 모든 필드의 get 메소드를 생성해 줍니다.
@RequiredArgsConstructor // 2020.03.14 (토) 오후 10:26 Reference#1 (1) 선언된 모든 final 필드가 포함된 생성자를 생성해 줍니다. (2) final 이 없는 필드는 생성자에 포함되지 않습니다.
public class TestResponseDto {

    private final String name;
    private final int amount;
}

/*
 * Reference#1
 * 스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱 지음, 프리렉
 */