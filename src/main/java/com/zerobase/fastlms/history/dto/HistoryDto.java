package com.zerobase.fastlms.history.dto;

import com.zerobase.fastlms.history.entity.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryDto {
    String userId;
    String userAg;
    String userIp;

    //추가컬럼
    long totalCount;
    long seq;
    public static HistoryDto of(History history){
        return HistoryDto.builder()
                .userId(history.getUserId())
                .userAg(history.getUserAgent())
                .userIp(history.getUserIp())
                .build();
    }

    public static List<HistoryDto> of(List<History> histories) {
        if(histories== null){
            return null;
        }
        List<HistoryDto> historyList = new ArrayList<>();
        int cnt = 1;
        for(History x : histories){
            HistoryDto history = HistoryDto.of(x);
            history.setSeq(cnt);
            historyList.add(history);
            cnt++;
        }
        return historyList;
    }
}
