package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputConverter;

import java.util.Map;

public class InputView {
    private static final String REQUEST_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String REQUEST_MENU_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";


    public static int inputVisitDate(){
        System.out.println(REQUEST_VISIT_DATE_MESSAGE);
        return InputConverter.getDate(Console.readLine());
    }

    public static Map<String, Integer> inputMenuOrder(){
        System.out.println(REQUEST_MENU_ORDER_MESSAGE);
        return InputConverter.getMenuOrder(Console.readLine());
    }
}
