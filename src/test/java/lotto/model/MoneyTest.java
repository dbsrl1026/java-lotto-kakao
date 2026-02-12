package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("올바른 금액일 때")
    public void validateMoney(){
        assertThatCode(() -> new Money(1000)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("음수 금액일 때 예외 발생")
    public void validateNegativeMoney() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("금액은 0원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("합연산")
    public void sum(){
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);
        assertThat(money1.sum(money2)).isEqualTo(new Money(3000));
    }

    @Test
    @DisplayName("차연산")
    public void minus() {
        Money money1 = new Money(2000);
        Money money2 = new Money(500);
        assertThat(money1.minus(money2)).isEqualTo(new Money(1500));
    }

    @Test
    @DisplayName("차연산 결과가 음수일 때 예외 발생")
    public void minusNegativeResult() {
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);
        assertThatThrownBy(() -> money1.minus(money2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @Test
    @DisplayName("나눗셈 0으로 나눌 때 예외 발생")
    public void divisionByZero() {
        Money money = new Money(1000);
        Money zero = new Money(0);
        assertThatThrownBy(() -> money.division(zero))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}