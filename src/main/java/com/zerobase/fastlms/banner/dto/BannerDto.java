package com.zerobase.fastlms.banner.dto;


import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerDto {
    private long id;
    private long seq;
    private String bannerName;
    private String linkUrl;
    private String targetNewPage;
    private int sortValue;
    private boolean frontOpen;

    private String bannerUrl;
    private LocalDate addDt;
    private long totalCount;


    public static BannerDto of(Banner banner){
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .bannerUrl(banner.getBannerUrl())
                .addDt(banner.getAddDt())
                .build();
    }
    public static List<BannerDto> of(List<Banner> banners) {
        if(banners == null){
            return null;
        }
        List<BannerDto> bannerList = new ArrayList<>();
        int cnt =1;
        for(Banner x : banners){
            BannerDto banner = BannerDto.of(x);
            banner.setSeq(cnt);
            bannerList.add(banner);
            cnt++;
        }
        return bannerList;
    }
}
