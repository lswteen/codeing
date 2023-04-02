package com.codeing.code;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Example003 {

    public static int solution(String start_date, String end_date, String[] login_dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate startDate = LocalDate.parse(start_date.substring(0, 5), formatter);
        LocalDate endDate = LocalDate.parse(end_date.substring(0, 5), formatter);

        List<LocalDate> loginDateList = Arrays.stream(login_dates)
                .map(dateStr -> LocalDate.parse(dateStr, formatter))
                .filter(date -> date.isAfter(startDate.minusDays(1)) && date.isBefore(endDate.plusDays(1)))
                .collect(Collectors.toList());

        int maxConsecutiveWeekdays = 0;
        int consecutiveWeekdays = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                consecutiveWeekdays = 0;
                continue;
            }
            if (loginDateList.contains(date)) {
                consecutiveWeekdays++;
                if (consecutiveWeekdays > maxConsecutiveWeekdays) {
                    maxConsecutiveWeekdays = consecutiveWeekdays;
                }
            } else {
                consecutiveWeekdays = 0;
            }
        }

        return maxConsecutiveWeekdays;
    }


    public static void main(String[] args) {
        String start_date = "05/04 MON";
        String end_date = "05/30";
        String[] login_dates = {"05/26","05/25","05/27","05/10","05/11","05/23","05/22","05/21","05/06","05/09","05/07","05/08"};

        int result = Example003.solution(start_date, end_date, login_dates);
        System.out.println(result); // 예상 결과값: 5
    }

}
