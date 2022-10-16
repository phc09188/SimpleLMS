package com.zerobase.fastlms.banner.service;


import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.mapper.BannerMapper;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import com.zerobase.fastlms.course.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;
    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if(!CollectionUtils.isEmpty(list)){
            int i = 0;
            for(BannerDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() -i);
                i++;
            }
        }
        return list;
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .bannerUrl(parameter.getUrlFilename())
                .linkUrl(parameter.getLinkUrl())
                .targetNewPage(parameter.getTargetNewPage())
                .addDt(LocalDate.now())
                .sortValue(parameter.getSortValue())
                .frontOpen(parameter.isFrontOpen())
                .build();
        bannerRepository.save(banner);


        return true;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalbanner = bannerRepository.findById(parameter.getId());
        if(!optionalbanner.isPresent()){
            return false;
        }
        Banner banner = optionalbanner.get();
        if(parameter.getBannerUrl() != null){
            banner.setBannerUrl(parameter.getUrlFilename());
        }
        banner.setBannerName(parameter.getBannerName());
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setTargetNewPage(parameter.getTargetNewPage());
        banner.setSortValue(parameter.getSortValue());
        banner.setFrontOpen(parameter.isFrontOpen());

        bannerRepository.save(banner);
        return true;
    }

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public boolean updateStatus(String bannerName, String targetNewPage) {
        Optional<Banner> optionalBanner = bannerRepository.findByBannerName(bannerName);
        if(!optionalBanner.isPresent()){
            throw new UsernameNotFoundException("배너 정보가 없습니다.");
        }
        Banner banner = optionalBanner.get();

        banner.setTargetNewPage(targetNewPage);
        bannerRepository.save(banner);
        return true;
    }
}
