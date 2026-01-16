package step3;
// TODO: enum 개념 조금 더 이해해보기.
// 미리 정의된 상수들의 집합 + 기본적으로 public static final이라고 생각하면 된다. (final + 상수이기 때문에 모두 대문자로)
// enum은 new 키워드로 객체 생성할 필요 없다. -> JVM이 프로그램 시작 시 미리 다 만들어두기 때문

import java.util.Arrays;

public enum OperatorType {
    // enum 상수 (enum값, enum 인스턴스) 라고 한다.. 밑의 코드들이 있으면 실행시점에 JVM이 자동으로 객체 1개씩 생성.
    PLUS('+') {
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        @Override
        public double apply(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        @Override
        public double apply(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    };
    // 이 객체들은 딱 한 번만 생성됨(싱글톤이라고 함)

    // char(문자열) 형식의 symbol(연산기호) 필드 (속성) 추가
    private final char symbol;

    // 생성자
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // 추상메서드
    public abstract double apply(double num1, double num2);

    // TODO: 아직 개념이 완전히 내 것이 아닌듯. 추가학습 할 것(스트림, 람다, orElseThrow())
    public static OperatorType findSymbol(char operator) {
       return Arrays.stream(OperatorType.values())
               .filter(o -> o.symbol == operator)
               .findFirst()
               .orElseThrow(()-> new IllegalArgumentException("잘못된 연산자입니다."));
    }
}
