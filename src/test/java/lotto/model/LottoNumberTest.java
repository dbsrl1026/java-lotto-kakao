package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("올바른 번호(1-45)일 때")
    public void validateNumber(){
        assertThatCode(() -> LottoNumber.of(5)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("올바르지 않은 번호일 때 : 46")
    public void invalidNumber46(){
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호는 1-45 사이 값이어야 합니다");
    }

    @Test
    @DisplayName("올바르지 않은 번호일 때 : 0")
    public void invalidNumber0(){
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호는 1-45 사이 값이어야 합니다");
    }

    @Test
    @DisplayName("로또 번호 일치 여부 검사 - 일치할때")
    public void isEqual(){
        LottoNumber number1 = LottoNumber.of(1);
        LottoNumber number2 = LottoNumber.of(1);
        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isSameAs(number2);
    }

    @Test
    @DisplayName("로또 번호 일치 여부 검사 - 일치하지 않을 때")
    public void isNotEqual(){
        LottoNumber number1 = LottoNumber.of(1);
        LottoNumber number2 = LottoNumber.of(2);
        assertThat(number1).isNotEqualTo(number2);
    }
}
