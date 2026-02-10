package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MoneyTest {

    @Test
    @DisplayName("올바른 금액일 떄")
    public void validateMoney(){
        assertThatCode(() -> new Money(1000));

    }

    @Test
    @DisplayName("합연산")
    public void sum(){
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);
        assertThat(money1.sum(money2)).isEqualTo(new Money(3000));
    }

}