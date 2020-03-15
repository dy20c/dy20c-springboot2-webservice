package com.dy20c.test.springboot.web;

import com.dy20c.test.springboot.dto.TestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 2020.03.14 (토) 오후 7:48 Reference#1 (1) 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줍니다. (2) 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됩니다.
public class TestController {

    @GetMapping("/test") // 2020.03.14 (토) 오후 7:48 Reference#1 (1) HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줍니다. (2) 예전에는 @RequestMapping(method= RequestMethod.GET)으로 사용되었습니다. (3) 이제 이 프로젝트는 /test 로 요청이 오면 문자열 test를 반환하는 기능을 가지게 되었습니다.
    public String test(){
        return "test";
    }

    @GetMapping("/test/dto") //2020.03.14 (토) 오후 10:47 Reference#1 @RequestParam (1)외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다. (2) 여기서는 외부에서 name (@RequestParam("name")) 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됩니다.
    public TestResponseDto testDto(@RequestParam("name") String name,
                                   @RequestParam("amount") int amount){
        return new TestResponseDto(name, amount);
    }
}

/*
* Reference#1
* 스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱 지음, 프리렉
*/
