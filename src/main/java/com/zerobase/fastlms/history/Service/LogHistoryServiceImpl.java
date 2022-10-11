package com.zerobase.fastlms.history.Service;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.history.dto.HistoryDto;
import com.zerobase.fastlms.history.entity.History;
import com.zerobase.fastlms.history.repository.HistoryRepository;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LogHistoryServiceImpl implements  LogHistoryService{
    private final MemberRepository memberRepository;
    private final HistoryRepository historyRepository;


    @Override
    public boolean insert(HistoryDto history) {
        Optional<Member> memberOptional = memberRepository.findById(history.getUserId());
        if(memberOptional.isPresent()){
            History result = History.builder()
                    .userId(history.getUserId())
                    .userIp(history.getUserIp())
                    .userAgent(history.getUserAg())
                    .logDt(LocalDateTime.now())
                    .build();
            historyRepository.save(result);
            Member member = memberOptional.get();
            member.setLastLoginDt(LocalDateTime.now());
            memberRepository.save(member);
            return true;
        }
        return false;
    }
}
