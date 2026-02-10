package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {


    @Test
    @DisplayName("유효한 당첨로또 생성")
    public void createWinningLotto() {
        LottoNumber bonusNum = new LottoNumber(33); // 보넛스랑 answer 안겹치는니 확인필요
        assertThatCode(() -> new WinningLotto(new LottoTicket(1,2,3,4,5,6), bonusNum));
    }

    @Test
    @DisplayName("보너스 번호가 겹친 당첨로또")
    public void InvalidWinningLotto() {

        LottoNumber bonusNum = new LottoNumber(1);
        assertThatThrownBy(() -> new WinningLotto(new LottoTicket(1,2,3,4,5,6), bonusNum))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("보너스 숫자 겹침!");
    }

}