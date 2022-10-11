package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.history.Service.LogHistoryService;
import com.zerobase.fastlms.history.Service.LogHistoryServiceImpl;
import com.zerobase.fastlms.history.dto.HistoryDto;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
@Slf4j
public class LogAuthenticationSuccess implements AuthenticationSuccessHandler {

    private final LogHistoryService service;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HistoryDto dto = new HistoryDto();
        dto.setUserId(authentication.getName());
        dto.setUserAg(RequestUtils.getUserAgent(request));
        dto.setUserIp(RequestUtils.getUserIp(request));
        boolean result = service.insert(dto);
        if(result){
            log.info("success");
        }
        String root = "/";
        response.sendRedirect(root);
    }
}
