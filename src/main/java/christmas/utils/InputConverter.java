package christmas.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static christmas.utils.ErrorMessage.INVALID_ORDER;
import static christmas.utils.ErrorMessage.INVALID_VISIT_DATE;

public class InputConverter {
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_DASH = "-";


    public static Integer getDate(String value) {
        return parseStringToNumber(value, INVALID_VISIT_DATE);
    }


    public static Map<String, Integer> getMenuOrder(String value) {
        validateEndsWithDelimiter(value);

        Map<String, Integer> result = new HashMap<>();

        Arrays.stream(value.split(DELIMITER_COMMA))
                .forEach(menu -> storeMenu(menu, result));
        return result;
    }

    private static void storeMenu(String value, Map<String, Integer> result) {
        validateEachMenuForm(value);
        String[] split = value.split(DELIMITER_DASH);
        result.put(split[0], getMenuCount(split[1]));
    }

    private static void validateEachMenuForm(String value) {
        if(!value.contains(DELIMITER_DASH)){
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private static Integer getMenuCount(String value) {
        return parseStringToNumber(value, INVALID_ORDER);
    }


    private static Integer parseStringToNumber(String value, ErrorMessage message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(message.getMessage());
        }
    }


    private static void validateEndsWithDelimiter(String input) {
        if (input.endsWith(DELIMITER_COMMA)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}
