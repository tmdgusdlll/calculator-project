package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import step3.OperatorType;
public class ArithmeticCalculator {
    // 캡슐화 private 키워드 사용하여 접근제어(App 클래스의 main메서드로부터)
    // 연산 결과 저장하는 컬레션 타입(ArratList) 생성
    private List<Double> history = new ArrayList<>();


    // 제네릭 메서드 선언 (double 타입의 값을 받아도 연산이 되도록 만들기)
    // <T extends Number> -> Number를 상속한 타입만 받겠다. 그냥 <T>만 하게되면 String, boolean 등등 말도 안되는 값도 받게됨!
    public <T extends Number, U extends Number> double calculate(T num1, U num2, OperatorType operator) {
        // 사용자가 입력한 num1, num2의 값은 double로 반환해서 가져오는 작업
        double dnum1 = num1.doubleValue();
        double dnum2 = num2.doubleValue();
        double result = operator.apply(dnum1, dnum2);

//        OperatorType symbol =  OperatorType.findSymbol(operator);

//        switch (symbol) {
//            case PLUS -> result = dnum1 + dnum2;
//            case MINUS -> result = dnum1 - dnum2;
//            case MULTIPLY -> result = dnum1 * dnum2;
//            case DIVIDE -> {
//                if (dnum2 == 0) {
//                    throw new ArithmeticException("0으로 나눌 수 없습니다.")
//                }
//                result = dnum1 / dnum2;
//            }
//        }
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
    // TODO : Optional 써보기! (아무 계산도 안 했을 떄 삭제 시 어떻게 할 지)
    public void removeResult() {
        history.remove(0);
    }

    // 특정 값보다 큰 결과 조회 (람다 & 스트림 활용)
    public List<Double> getResultsGreaterThan(double threshold) {
        return history.stream()
                .filter(v -> v >threshold)
                .collect(Collectors.toList());
    }
}



