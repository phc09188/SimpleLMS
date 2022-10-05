package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {
    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정을 활성화 한다.
     */
    boolean emailAuth(String uuid);

    /**
     * 입력한 이메일로 비밀번호 초기화 정보를 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);

    /**
     * 입력받은 uuid에 대해서 비밀번호 변경
     */
    boolean resetPassword(String id, String password);

    /**
     * 입력받은 uuid값이 유효한지 확인
     */
    boolean checkResetPassword(String uuid);

    /**
     * 관리자에서만 사용 가능
     */
    List<MemberDto> list(MemberParam parameter);

    /**
     * 회원상세정보
     */
    MemberDto detail(String userId);
}
