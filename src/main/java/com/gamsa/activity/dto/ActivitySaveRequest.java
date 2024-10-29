package com.gamsa.activity.dto;

import com.gamsa.activity.constant.Category;
import com.gamsa.activity.domain.Activity;
import com.gamsa.activity.domain.District;
import com.gamsa.activity.domain.Institute;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ActivitySaveRequest {

    private final Long actId;
    private final String actTitle;
    private final String actLocation;
    private final String description;
    private final LocalDateTime noticeStartDate;
    private final LocalDateTime noticeEndDate;
    private final LocalDateTime actStartDate;
    private final LocalDateTime actEndDate;
    private final int actStartTime;
    private final int actEndTime;
    private final int recruitTotalNum;
    private final boolean adultPossible;
    private final boolean teenPossible;
    private final boolean groupPossible;
    private final int actWeek;
    private final String actManager;
    private final String actPhone;
    private final String url;
    private final Category category;
    private final Long instituteId;
    private final Integer sidoGunguCode;

    public Activity toModel(Institute institute, District sidoGungu) {
        return Activity.builder()
                .actId(actId)
                .actTitle(actTitle)
                .actLocation(actLocation)
                .description(description)
                .noticeStartDate(noticeStartDate)
                .noticeEndDate(noticeEndDate)
                .actStartDate(actStartDate)
                .actEndDate(actEndDate)
                .actStartTime(actStartTime)
                .actEndTime(actEndTime)
                .recruitTotalNum(recruitTotalNum)
                .adultPossible(adultPossible)
                .teenPossible(teenPossible)
                .groupPossible(groupPossible)
                .actWeek(actWeek)
                .actManager(actManager)
                .actPhone(actPhone)
                .url(url)
                .category(category)
                .institute(institute)
                .sidoGungu(sidoGungu)
                .build();
    }
}