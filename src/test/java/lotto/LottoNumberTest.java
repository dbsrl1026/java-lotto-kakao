package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



class LottoNumberTest {

    @Test
    @DisplayName("올바른 번호(1-45)일 때")
    public void validateMoney(){
        assertThatCode(() -> new LottoNumber(5));
    }

    @Test
    @DisplayName("올바르지 않은 번호일 때")
    public void negativeMoney(){
        assertThatThrownBy(() -> new LottoNumber(64))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호는 1-45 사이 값이어야 합니다");
    }

}