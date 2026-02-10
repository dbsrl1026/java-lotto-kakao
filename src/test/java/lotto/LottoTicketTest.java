package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    @DisplayName("정상적인 로또 생성")
    public void createTicket(){
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        assertThatCode(()->new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호 개수가 부족할 때")
    public void notEnoughNumber(){
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers)).isInstanceOf(RuntimeException.class)
                .hasMessage("로또 티켓에는 6개의 번호가 필요합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 때")
    public void duplicateNumber(){
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(3),
                new LottoNumber(6)
        );

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers)).isInstanceOf(RuntimeException.class)
                .hasMessage("로또 티켓에는 6개의 번호가 필요합니다.");
    }

}