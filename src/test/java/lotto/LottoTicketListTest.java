package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;


class LottoTicketListTest {


    @Test
    @DisplayName("제대로 생성돼는지")
    public void createLottoTicketList() {
        assertThatCode(() -> new LottoTicketList(List.of(
                new LottoTicket(1,2,3,4,5,6),
                new LottoTicket(1,2,3,4,5,6),
                new LottoTicket(1,2,3,4,5,6),
                new LottoTicket(1,2,3,4,5,6),
                new LottoTicket(1,2,3,4,5,6),
                new LottoTicket(1,2,3,4,5,6)
        )));
    }

    @Test
    @DisplayName("null값이어도 정상 초기화 되는지 검사")
    public void lottoTicketListIsNull() {
        assertThatCode(() -> new LottoTicketList(null));
    }


}