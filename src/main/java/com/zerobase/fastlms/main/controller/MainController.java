package com.zerobase.fastlms.main.controller;


/*
MainPage 의 목적
주소와 물리적인 파일을 매핑하기 위해서
하나의 주소에 대해서
어디서 매핑하고 누가 매핑하지?  메소드가 효율적이다 라고 한다.
 --> 클래스 or 속성 or 메소드 3중에 하나다

*/

import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;


    @RequestMapping("/")
    public String index(){
        /*String email = "phc09188@gmail.com";
        String subject = "안녕하세요 제로베이스 입니다.";
        String text = "<p>안녕하세요</p><p>반갑습니다</p>";
        mailComponents.sendMail(email, subject,text);*/


        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied(){
        return "error/denied";
    }



}
