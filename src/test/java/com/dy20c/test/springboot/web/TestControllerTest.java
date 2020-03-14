package com.dy20c.test.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // 2020.03.14 (토) 오후 8:09 Reference#1 @RunWith(SpringRunner.class) (1) 테스트를 진행할 떄 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다. (2) 여기서는 SpringRunner 라는 스프링 실행자를 사용합니다. (3) 즉, 스프링부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
@WebMvcTest(controllers = TestController.class) // 2020.03.14 (토) 오후 8:09 Reference#1 @WebMVCTest, (1) 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션입니다. (2) 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있습니다. (3) 단, @Service, @Component, @Repository 등은 사용할 수 없습니다. (4) 여기서는 컨트롤러만 사용하기 때문에 선언합니다.
public class TestControllerTest {

    @Autowired // 2020.03.14 (토) 오후 8:09 Reference#1 @Autowired , (1)스프링이 관리하는 빈(Bean)을 주입 받습니다.
    private MockMvc mvc; //2020.03.14 (토) 오후 8:09 Reference#1  private MockMvc mvc, (1) 웹 API를 테스트할 떄 사용합니다. 스프링 MVC 테스트의 시작점입니다. 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.

    @Test
    public void test가_리턴된다() throws Exception{
        String test = "test";

        mvc.perform(get("/test")) //2020.03.14 (토) 오후 8:09 Reference#1 mvc.perform(get("/test")), (1)MockMvc를 통해 /test 주소로 HTTP GET 요청을 합니다. (2) 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.
                .andExpect(status().isOk()) // 2020.03.14 (토) 오후 8:09 Reference#1 .andExpect(status().isOk()) (1) mvc.perform의 결과를 검증합니다. (2) HTTP header의 Status를 검증합니다. (3) 우리가 흔히 알고 있는 200, 404, 500 등의 상태를 검증합니다. (4) 여기선 OK 즉, 200인지 아닌지를 검증합니다.
                .andExpect(content().string(test)); // 2020.03.14 (토) 오후 8:09 Reference#1 .andExpect(content().string(test)) (1)mvc.perform의 결과를 검증합니다. (2) 응답 본문의 내용을 검증합니다. (3)Controller 에서 "test"를 리턴하기 때문에 이 값이 맞는지 검증합니다.

    }

    @Test
    public void testDto가_리턴된다() throws Exception{
        String name = "test";
        int amount = 2002;

        mvc.perform(
                get("/test/dto")
                    .param("name",name) // 2020.03.14 (토) 오후 8:09 Reference#1 param, (1) API 테스트할 때 사용될 요청 파라미터를 설정 (2) 단, 값은 String만 허용됩니다. (3) 그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능합니다.
                    .param("amount", String.valueOf(amount)))
                        .andExpect(status().isOk()) // 2020.03.14 (토) 오후 8:09 Reference#1 jsonPath (1) JSON 응답 값을 필드 별로 검증할 수 있는 메소드입니다. (2) $를 기준으로 필드명을 명시합니다. (3) 여기서는 name과 amount를 검증하니 $.name,$.amount로 검증합니다.
                        .andExpect(jsonPath("$.name", is(name)))
                        .andExpect(jsonPath("$.amount", is(amount)));

    }
}

/*
 * Reference#1
 * 스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱 지음, 프리렉
 */
