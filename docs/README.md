# 4주 차 프리코스 미션: 크리스마스 프로모션 🎄

## 📄기능 요구사항 분석

### 메뉴 종류

```text
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

- 메뉴의 카테고리는 4가지(애피타이저, 메인, 디저트, 음료)
- 각 메뉴마다 이름과 가격을 가짐

### 이벤트 계획

디데이 할인을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31(12월 전체) 진행

- 크리스마스 디데이 할인
    - 기간 - 2023.12.1 ~ 2023.12.25
    - 내용 - 1,000원에서 시작하여 매일 할인 금액이 100원씩 증가
    - 1일에는 1,000원 -> 25일에는 3,400원 … n일 할인 금액 = 1000 + (n-1)*100
    - 총주문 금액에서 해당 금액만큼 할인
- 평일 할인
    - 주중(일,월,화,수,목) 적용
    - 디저트 메뉴 1개당 2,023원 할인
- 주말 할인
    - 주말(금,토) 적용
    - 메인 메뉴 1개당 2,023원 할인
- 특별 할인
    - 달력에 별이 그려진 날짜에 적용
    - 모든 일요일(3,10,17,24,31)과 크리스마스(25)일
    - 총주문 금액에서 1,000원 할인

## 📄구현 기능 목록

---

### 플래너 시작 문구 출력

- [x] OutputView: 정해진 문구를 출력한다
    - 문구 - ```안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.```

---

### 방문 날짜 입력

- [x] 사용자에게 방문 날짜를 입력받는다
    - [x] InputView: 1 이상 31 이하의 숫자를 입력받는다
        - 문구 - ```12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)```
    - [x] 예외처리
        - 범위를 벗어나는 경우 - [ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.

### 주문 메뉴 입력

- [x] 사용자에게 주문 메뉴를 입력받는다
    - [x] InputView: {메뉴이름}-{수량} 형태의 메뉴를 한번에 여러개 입력받는다
        - 문구 - ```주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)```
    - [x] 개발 요청 예외 처리
        - [x] 형식이 다른 경우 - [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
        - [x] 없는 메뉴인 경우 - [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
        - [x] 수량이 1 이상이 아닌 경우 - [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
        - [x] 중복 메뉴가 있는 경우 - [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
    - [x] 추가 예외 처리
        - [x] 음료만 주문한 경우 - [ERROR] 음료만 주문 시, 주문할 수 없습니다. 음료 이외의 메뉴도 포함해서 다시 입력해주세요.
        - [x] 총수량이 20을 초과한 경우 - [ERROR] 메뉴는 한 번에 총 20개까지만 주문할 수 있습니다. 개수를 조정하여 다시 입력해주세요.

---

### 날짜 문구 출력

- [x] OutputView: 사용자가 입력한 날짜에 따른 문구를 출력한다
    - 문구 - ```12월 {날짜}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!```

### 주문 메뉴 출력

- [x] 주문한 모든 메뉴의 이름과 수량을 출력한다(출력 순서는 자유)

```text
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
```

---

### 할인 전 총주문 금액 출력

- [x] OutputView: 총주문 금액을 출력한다

```text
<할인 전 총주문 금액>
142,000원
```

- [x] 모든 메뉴의 가격을 모두 더하는 기능

### 증정 메뉴 출력

- [x] OutputView: 증정메뉴를 출력한다
- [x] 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
    - 할인 전 총주문 금액이 12만원 이상인지 판단하는 기능

```text
<증정 메뉴>
샴페인 1개
```

- [x] 적용되지 않는다면 "없음"으로 출력

```
<증정 메뉴>
없음
```

### 혜택 내역 출력

- [x] 고객에게 적용된 이벤트 내역만 출력한다
    - 적용된 이벤트가 여러개 인 경우, 순서는 자유롭게 출력 가능
- [x] 총주문 금액 10,000원 이상부터 이벤트가 적용된다
- [x] 총 혜택금액 = 할인 금액의 합계 + 증정 메뉴의 가격

```text
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원

<총혜택 금액>
-31,246원
```

- [x] 고객이 입력한 날짜, 총주문 금액을 기반으로 적용 이벤트를 계산하는 기능
    - [x] 날짜
        - 크리스마스 디데이: 1000 + (n-1)*100
        - 평일: 디저트 개수 * 2023
        - 주말: 메인 개수 * 2023
    - [x] 총주문 금액
        - 증정 이벤트: 샴페인 1개(25,000원)
        - 해당 이벤트의 경우 적용하거나, 하지 않거나 두 경우만 존재

- [x] 적용된 이벤트가 없는 경우

```text
<혜택 내역>
없음
 
<총혜택 금액>
0원
```

### 할인 후 예상 결제 금액 출력

- [x] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액

```text
<할인 후 예상 결제 금액>
135,754원
```

### 12월 이벤트 배지 출력

- [x] 총 혜택 금액에 따라 다른 이벤트 배지를 부여한다
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타

```text
<12월 이벤트 배지>
산타
```

- [x] 적용된 배지가 없는 경우 "없음"으로 출력

```text
<12월 이벤트 배지>
없음
```

---

## 12월 이벤트 플래너의 예시

```text
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

## 🪄4주차 추가 요구사항

---

- [x] 주어진 InputView, OutputView 클래스를 참고하여 입출력 클래스 구현
    - 입력과 출력을 담당하는 클래스를 별도로 구현한다
    - 해당 클래스의 패키지, 메서드 반환타입, 시그니처는 자유이다

```text
public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();    
        // ...
    }
    // ...
}
```

```text
public class OutputView {
    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    // ...
}
```

## 프로그래밍 요구사항

---

- [x] JDK17 버전에서 실행 가능해야 한다. JDK17에서 정상적으로 동작해야 한다
- [x] 프로그램 실행의 시작점은 Application의 main()이다
- [x] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다
- [x] Java 코드 컨벤션 가이드를 준수한다
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다
- [x] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다
- [x] 프로그래밍 요구사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하지 않는다
- [x] indent(들여쓰기)의 depth는 3을 넘지 않는다.
- [x] 3항 연산자를 사용하지 않는다.
- [x] 함수(메서드)가 한 가지 일만 하도록 최대한 작게 만들자.
- [x] JUnit5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작하는지 테스트코드로 확인한다
- [x] else 예약어를 쓰지 않는다
- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI 로직은 제외한다
- [x] 사용자 입력 처리
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
    - “[ERROR]”로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다