package christmas.domain;

import java.util.Arrays;
import java.util.List;

public class DateConstant {
    public static final List<Integer> CHRISTMAS_DDAYS = Arrays.asList(
            1, 2, 3, 4, 5,
            6, 7, 8, 9, 10,
            11, 12, 13, 14, 15,
            16, 17, 18, 19, 20,
            21, 22, 23, 24, 25
    );

    public static final List<Integer> WEEKDAYS = Arrays.asList(
            3, 10, 17, 24, 31,
            4, 11, 18, 25,
            5, 12, 19, 26,
            6, 13, 20, 27,
            7, 14, 21, 28
    );

    public static final List<Integer> WEEKENDS = Arrays.asList(
            1, 8, 15, 22, 29,
            2, 9, 16, 23, 30
    );

    public static final List<Integer> SPECIAL_DAYS = Arrays.asList(
            3, 10, 17, 24, 25, 31
    );
}
