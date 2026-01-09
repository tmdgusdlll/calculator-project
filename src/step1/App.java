package step1;
import java.util.InputMismatchException;
import java.util.Scanner;

// 클래스 없이 기본적인 연산 계산기 만들기
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2 = 0;
        int result = 0;
        char operator;

        while (true) {

            while (true) {
                // num1에 숫자가 아닌 값 예외처리
                try {
                    // 양의 정수(0포함) 입력 받기
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }

            while (true) {
                // 연산자 기호 입력 받기
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                // TODO: charAt() ->문자열에서 한 문자만 가져오는 것. (사칙연산 기호는 문자열임)
                // 스캐너를 통해 입력받을 값은 사칙연간 기호 하나 이므로 인덱스 0을 통해 출력가능
                operator = sc.nextLine().charAt(0);
                // 연산자가 아닌 값 예외처리
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                }
                System.out.println("올바른 기호가 아닙니다.");
            }

            while (true) {
                // 0으로 나누기 예외처리
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = Integer.parseInt(sc.nextLine());

                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
            // 계산
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/': // TODO: 나누기 0 예외처리 필요!
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("올바른 연산자가 아닙니다.");
            }
            System.out.println("결과: " + result);

            // 더 계산하시겠습니까? 라는 문구에 대답을 듣고 다시 반복되거나 끝내야하는데 첫번째 숫자 입력하라는 문구가 자꾸 같이 출력됨.
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String answer = sc.nextLine();


            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}


