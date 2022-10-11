package com.zerobase.fastlms.history.Service;

import com.zerobase.fastlms.history.dto.HistoryDto;

public interface LogHistoryService {
    boolean insert(HistoryDto history);
}
