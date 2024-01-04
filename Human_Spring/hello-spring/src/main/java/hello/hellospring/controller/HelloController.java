package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "say hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http 통신방식에 응답 body부분을 직접 주입하겠다 라는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }
    // 템플릿 엔진과 차이점
    // 입력받은 값(body의 값) 이 그대로 전달된다
    // Html소스가 아닌 값만 출력되는 로직
    // 현재 소스방식은 주로 사용하는 방식은 아니고 , API를 주로 사용하는 목적은 데이터를 요청할때 사용한다


    // API 예제
    // 객체를 하나 생성
    static class Hello{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}
