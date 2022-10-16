package com.zerobase.fastlms.banner.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BannerInput {
    private long id;
    private String bannerName;

    private String bannerUrl;
    private String linkUrl;
    private String targetNewPage;
    private int sortValue;
    private boolean frontOpen;
    private LocalDate addDt;


    String filename;
    String urlFilename;

    String idList;
}
