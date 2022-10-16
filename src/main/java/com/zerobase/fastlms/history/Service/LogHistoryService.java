package com.zerobase.fastlms.history.Service;

import com.zerobase.fastlms.history.dto.HistoryDto;

import java.util.List;

public interface LogHistoryService {
    boolean insert(HistoryDto history);

    List<HistoryDto> detail(String userId);
}
