package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketList {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(){
        this(new ArrayList<>());
    }

    public LottoTicketList(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void insertTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }
}
