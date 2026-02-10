package lotto;

import java.util.List;

public class LottoTicketList {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            throw new RuntimeException("잘못된 호출");
        }
        this.lottoTickets = lottoTickets;
    }
}
