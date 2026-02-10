package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningRankTest {

    @Test
    @DisplayName("1등일 때")
    public void firstRank(){
        WinningRank rank = WinningRank.getRank(6, 0);
        assertThat(rank).isEqualTo(WinningRank.FIRST);
    }

    @Test
    @DisplayName("2등일 때")
    public void secondRank(){
        WinningRank rank = WinningRank.getRank(5, 1);
        assertThat(rank).isEqualTo(WinningRank.SECOND);
    }

    @Test
    @DisplayName("4등일 때")
    public void fourthRank(){
        WinningRank rank = WinningRank.getRank(4, 1);
        assertThat(rank).isEqualTo(WinningRank.FOURTH);
    }

    @Test
    @DisplayName("등수가 없을 때")
    public void noneRank(){
        WinningRank rank = WinningRank.getRank(2,1);
        assertThat(rank).isEqualTo(WinningRank.NONE);
    }

}