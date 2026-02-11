package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @DisplayName("로또 등수 판별")
    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("provideLottoTicketAndRank")
    public void checkWinningRank(LottoTicket ticket, WinningRank expectedRank) {
        // 당첨 번호: 1, 2, 3, 4, 5, 6 | 보너스: 8
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(1, 2, 3, 4, 5, 6), new LottoNumber(8));
        WinningRank rank = winningLotto.checkRank(ticket);
        assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoTicketAndRank() {
        return Stream.of(
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 6), WinningRank.FIRST),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 8), WinningRank.SECOND),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 7), WinningRank.THIRD),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 7, 8), WinningRank.FOURTH),
                Arguments.of(new LottoTicket(1, 2, 3, 7, 8, 9), WinningRank.FIFTH),
                Arguments.of(new LottoTicket(1, 2, 7, 8, 9, 10), WinningRank.NONE)
        );
    }
}
