package step3;

import java.util.ArrayList;
import java.util.List;
import step3.OperatorType;
public class ArithmeticCalculator {
    // 캡슐화 private 키워드 사용하여 접근제어(App 클래스의 main메서드로부터)
    // 연산 결과 저장하는 컬레션 타입(ArratList) 생성
    private List<Double> history = new ArrayList<>();

    double result;


    // 제네릭 메서드 선언 (double 타입의 값을 받아도 연산이 되도록 만들기)
    public <T extends Number> double calculate(T num1, T num2, char operator) {
        // 사용자가 입력한 num1, num2의 값은 double로 반환해서 가져오는 작업
        double dnum1 = num1.doubleValue();
        double dnum2 = num2.doubleValue();

       OperatorType symbol =  OperatorType.findSymbol(operator);

        switch (symbol) {
            case PLUS:
                result = dnum1 + dnum2;
                break;
            case MINUS:
                result = dnum1 - dnum2;
                break;
            case MULTIPLY:
                result = dnum1 * dnum2;
                break;
            case DIVIDE:
                result = dnum1 / dnum2;
                break;
            default:
                System.out.println("올바른 연산자가 아닙니다.");
        }
        // 연산 결과값 저장
//        history.add(result);   -> 저장하는 역할을 세터에게 넘겼음 *한 메서드당 하나의 기능을 맡는 것이 좋다.
        return result;
    }

    // Getter 메서드
    public List<Double> getHistory() {
        return this.history;
    }

    // Setter 메서드
    public void setHistory(double newHistoryNumber) {
        // 수정할 값을 따로 반환해서 어디 저장하지 않고 바로 history에 추가하는 것이 효율적.
        this.history.add(newHistoryNumber);
    }

    // 삭제하는 메서드
    // 가장 먼저 저장된 데이터 -> 배열의 원소..? 에서 0번인덱스 삭제하면 되나?
    public void removeResult() {
        history.remove(0);
    }
}



