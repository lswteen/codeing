package com.codeing.code;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Example004 {

    static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .parseDefaulting(ChronoField.YEAR, 2023)
            .append(DateTimeFormatter.ofPattern("M/d"))
            // use English Locale to correctly parse month and day of week
            .toFormatter();

//    public static int solution(String start_date, String end_date, String[] login_dates) {
//        final int WEEKEND = -1;
//        LocalDate startDate = LocalDate.parse(start_date.substring(0,5),formatter);
//        LocalDate endDate = LocalDate.parse(end_date.substring(0,5),formatter);
//        LocalDate[] eventDates = new LocalDate[(int)
//                ChronoUnit.DAYS.between(startDate, endDate) + 1];
//        for (int i = 0; i < eventDates.length; i++) {
//            eventDates[i] = startDate.plusDays(i);
//        }
//        Map<LocalDate, Integer> dateMap = new HashMap<>();
//        for (LocalDate date : eventDates) {
//            if (date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() <= 5) {
//                dateMap.put(date, 0);
//            } else {
//                dateMap.put(date, WEEKEND);
//            }
//        }
//        for (String login_date : login_dates) {
//            LocalDate date = LocalDate.parse(login_date, formatter);
//            if (dateMap.containsKey(date) && dateMap.get(date) != WEEKEND) {
//                dateMap.put(date, 1);
//            }
//        }
//        int maxWeekday = 0;
//        int currWeekday = 0;
//        for (LocalDate date : eventDates) {
//            if (dateMap.get(date) == 1) {
//                currWeekday++;
//            } else {
//                maxWeekday = Math.max(maxWeekday, currWeekday);
//                currWeekday = 0;
//            }
//        }
//        maxWeekday = Math.max(maxWeekday, currWeekday);
//        return maxWeekday;
//    }


    public static int solution(String start_date, String end_date, String[] login_dates) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d");
        LocalDate startDate = LocalDate.parse(start_date, formatter);
        LocalDate endDate = LocalDate.parse(end_date, formatter);
        int maxContinuousWeekdays = 0;
        int currentContinuousWeekdays = 0;

        for (String login_date : login_dates) {
            LocalDate loginDate = LocalDate.parse(login_date, formatter);
            if (loginDate.isBefore(startDate) || loginDate.isAfter(endDate)) {
                continue;
            }
            DayOfWeek dayOfWeek = loginDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                continue;
            }

            if (currentContinuousWeekdays == 0) {
                currentContinuousWeekdays = 1;
            } else {
                LocalDate previousDate = loginDate.minusDays(1);
                DayOfWeek previousDayOfWeek = previousDate.getDayOfWeek();
                if (previousDayOfWeek == DayOfWeek.SUNDAY || previousDayOfWeek == DayOfWeek.MONDAY) {
                    currentContinuousWeekdays = 1;
                } else {
                    currentContinuousWeekdays++;
                }
            }
            maxContinuousWeekdays = Math.max(maxContinuousWeekdays, currentContinuousWeekdays);
        }

        return maxContinuousWeekdays;
    }

    public static void main(String[] args) {
        String start_date = "05/04";
        String end_date = "05/30";
        String[] login_dates = {"05/26","05/25","05/27","05/10","05/11","05/23","05/22","05/21","05/06","05/09","05/07","05/08"};
        System.out.println(solution(start_date, end_date, login_dates));  // 5
    }


}
