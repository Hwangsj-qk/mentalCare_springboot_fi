package com.busanit.mentalCare.model;

import java.time.Duration;
import java.time.LocalDateTime;

// 상대적 시간을 표현하기 위한 메소드
public class Time {

    public static String getTimeDifference(LocalDateTime pastTime, LocalDateTime currentTime) {
        Duration duration = Duration.between(pastTime, currentTime);

        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);

        long years = (absSeconds / 86400) / (30 * 12);
        long days = absSeconds / 86400;
        long hours = (absSeconds % 86400) / 3600;
        long minutes = (absSeconds % 3600) / 60;
        long secs = absSeconds % 60;

        StringBuilder timeDifference = new StringBuilder();

        if(years > 0) {
            timeDifference.append(years).append("년 전");
        } else if (days > 0) {
           timeDifference.append(pastTime.getMonthValue()).append("/").append(pastTime.getDayOfMonth());
        } else if (hours > 0) {
            timeDifference.append(hours).append("시간 전");
        } else if (minutes > 0) {
            timeDifference.append(minutes).append("분 전");
        } else {
            timeDifference.append(secs).append("초 전");
        }

        return timeDifference.toString();
    }

    /* Description
    * - 게시판 작성 시간을 상대적 시간으로 계산하여 나타내기 위한 메소드
    * - 현재 시간을 기준으로 작성 시간이 얼마나 지났는지에 대해 나타냄 */
}
