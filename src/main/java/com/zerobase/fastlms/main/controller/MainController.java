package com.zerobase.fastlms.main.controller;


import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.RequestUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MemberRepository memberRepository;
    private final BannerRepository bannerRepository;
    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        List<Banner> all = bannerRepository.findAll();
        List<Banner> banners = new ArrayList<>();
        for(Banner x : all){
            if(x.isFrontOpen()){
                banners.add(x);
            }
        }

        model.addAttribute("banners", banners);
        return "index";
    }
    
    
    
    @RequestMapping("/error/denied")
    public String errorDenied() {
        
        return "error/denied";
    }
    
    
    
}
