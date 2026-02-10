package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningInfoTest {

    @Test
    @DisplayName("로또 단건 결과 저장")
    public void CreateWinningInfo() {
        LottoTicket lottoTicket = new LottoTicket(1,2,3,4,5,6);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(1,2,3,4,6,7), new LottoNumber(10));
        WinningInfo winningInfo = new WinningInfo();
        winningInfo.compare(lottoTicket, winningLotto);
        assertThat(winningInfo.getTotalPrice()).isEqualTo(WinningRank.THIRD.winningPrice);
    }

}