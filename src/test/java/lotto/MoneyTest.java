package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

    @Test
    @DisplayName("올바른 금액(0원 이상)일 떄")
    public void validateMoney(){
        assertThatCode(() -> new Money(1000));

    }

    @Test
    @DisplayName("올바르지 않은 금액(음수)일 때")
    public void negativeMoney(){
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("돈은 항상 0원 이상이어야 합니다.");
    }

}