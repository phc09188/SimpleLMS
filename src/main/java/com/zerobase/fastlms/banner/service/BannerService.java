package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.course.dto.CourseDto;

import java.util.List;

public interface BannerService {
    List<BannerDto> list(BannerParam parameter);

    boolean add(BannerInput bannerInput);

    BannerDto getById(long id);

    boolean set(BannerInput parameter);

    boolean del(String idList);

    boolean updateStatus(String bannerName, String targetNewPage);
}
