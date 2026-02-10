package lotto;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if(!validate(winningTicket, bonusNumber)) {
            throw new RuntimeException("보너스 숫자 겹침!");
        }
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private boolean validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        return !lottoTicket.duplicateNumber(bonusNumber);
    }


    public WinningRank checkRank(LottoTicket lottoTicket) {
        int matchCount = winningTicket.duplicateNumber(lottoTicket);
        int bounceCount = lottoTicket.duplicateNumber(bonusNumber) ? 1:0;
        return WinningRank.getRank(matchCount, bounceCount);
    }
}
