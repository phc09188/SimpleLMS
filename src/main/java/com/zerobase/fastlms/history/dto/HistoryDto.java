package com.zerobase.fastlms.history.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryDto {
    String userId;
    String userAg;
    String userIp;

}
