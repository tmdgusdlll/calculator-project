package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // Menu 클래스에서만 사용할 것.
    private static final Scanner sc = new Scanner(System.in);
    // ArithmeticCalculator 클래스의 객체(calculator)를 생성함으로서 그 메서드를 호출할 수 있다. (calculator.메서드명())
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    // 메뉴 실행 메서드
    public void start() {
        System.out.println("=== 계산기 메뉴 ===");
        System.out.println("1. 계산하기");
        System.out.println("2. 계산 기록 보기");
        System.out.println("3. 가장 처음 기록 삭제하기");
        System.out.println("4. 특정 값보다 큰 결과값 조회하기");
        System.out.println("0. 종료하기");
        System.out.println("=================");

        // TODO: 나중에 do - while로 바꿔볼까..?
        while (true) {
            int answer;

            try {
                System.out.print("계산기 메뉴를 선택하시오: ");
                answer = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            switch (answer) {
                case 1 -> calculate();
                case 2 -> showHistory();
                case 3 -> deleteFirst();
                case 4 -> showGreater();
                case 0 -> {
                    System.out.println("종료하시겠습니가? (exit 입력 시 종료): ");
                    String response = sc.nextLine();
                    if (response.equalsIgnoreCase("exit")) {
                        System.out.println("계산기를 종료합니다.");
                    }
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 계산 메서드
    public void calculate() {
        while (true) {
            double num1;
            double num2;
            double result = 0;
            char operator;
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = Double.parseDouble(sc.nextLine());  // 입력값(문자열)을 실수값으로 변환
                    break;                                    // 스캐너로 입력받은 값은 항상 문자열임
                } catch (NumberFormatException e) {          // 입력값이 변환이 안 될 경우 예외발생 (ex. "abc", "12a", ...)
                    System.out.println("숫자를 입력하세요.");
                }
            }

            OperatorType op;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                operator = sc.nextLine().charAt(0);// 입력받은 문자열 중 첫 번째 문자(인덱스 0)만 추출하겠다.
                try {
                    op = OperatorType.findSymbol(operator);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = Double.parseDouble(sc.nextLine());
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
            // 객체화를 했기 때문에 메서드 호출 가능
            result = calculator.calculate(num1, num2, op);
            calculator.setHistory(result);
            System.out.println("결과: " + result);

            while (true) {
                System.out.println("더 계산하시겠습니까? (y/n): ");
                String reStart = sc.nextLine();
                if (reStart.equalsIgnoreCase("y")) {
                    break;
                } else if (reStart.equalsIgnoreCase("n")) {
                    return;
                } else {
                    System.out.println("y 또는 n만 입력해주세요.");
                }
            }
        }

    }

    // 2번 입력시 기록 조회. (기록이 없을 때 예외처리)
    // ArithmeticCalculator 클래스의 메서드를 호출해 결과기록들을 가져온다.
    public void showHistory() {
        if (calculator.getHistory().isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
            return;
        }
        System.out.println("--계산 기록--");
        System.out.println(calculator.getHistory());

    }

    // 3번 입력시 가장 첫 기록 삭제. (기록이 없을 때 예외처리)
    public void deleteFirst() {
        // 계산 기록이 없는데 삭제 요청할 시 예외처리
        if (calculator.getHistory().isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
            return;
        }
        // 가장 처음 기록을 삭제하는 ArithmeticCalculator 클래스의 메서드 호출
        calculator.removeResult();
        System.out.println("삭제되었습니다.");
        System.out.println("--계산 기록--");
        System.out.println(calculator.getHistory());
    }

    // 4번 입력시 특정 값보다 큰 결과값 출력
    public void showGreater() {
        System.out.println("기준 값을 입력하세요: ");
        double threshold = sc.nextDouble();
        System.out.println("기준값 보다 큰 결과값들: " + calculator.getResultsGreaterThan(threshold));
    }
}
