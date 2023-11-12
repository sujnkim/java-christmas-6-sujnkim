package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum DateEvent {

    CHRISTMAS("크리스마스 디데이",
            Arrays.asList(
                    1, 2, 3, 4, 5,
                    6, 7, 8, 9, 10,
                    11, 12, 13, 14, 15,
                    16, 17, 18, 19, 20,
                    21, 22, 23, 24, 25)),
    WEEKDAY("평일",
            Arrays.asList(
                    3, 10, 17, 24, 31,
                    4, 11, 18, 25,
                    5, 12, 19, 26,
                    6, 13, 20, 27,
                    7, 14, 21, 28
            )),
    WEEKEND("주말",
            Arrays.asList(
                    1, 8, 15, 22, 29,
                    2, 9, 16, 23, 30
            )),
    SPECIAL("특별",
            Arrays.asList(3, 10, 17, 24, 25, 31));


    private String eventType;
    private List<Integer> days;

    DateEvent(String eventType, List<Integer> days) {
        this.eventType = eventType;
        this.days = days;
    }


    public static List<DateEvent> findApplyEventByDate(int visitDate) {
        return Arrays.stream(DateEvent.values())
                .filter(discount -> discount.days.contains(visitDate))
                .toList();
    }

    public static int getDDayDiscountPrice(int visitDate) {
        if (CHRISTMAS.days.contains(visitDate)) {
            return 1000 + (visitDate - 1) * 100;
        }
        return 0;
    }
}
