package lotto;

import java.util.List;

public class WinningLotto {
    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if(!validate(lottoTicket, bonusNumber)) {
            throw new RuntimeException("보너스 숫자 겹침!");
        }
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private boolean validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        return !lottoTicket.duplicateNumber(bonusNumber);
    }


}
