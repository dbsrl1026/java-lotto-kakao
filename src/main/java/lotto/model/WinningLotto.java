package lotto.model;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        validate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.hasDuplicateNumber(bonusNumber)) {
            throw new RuntimeException("보너스 숫자 겹침!");
        }
    }

    public WinningRank checkRank(LottoTicket lottoTicket) {
        int matchCount = winningTicket.hasDuplicateNumber(lottoTicket);
        int bounceCount = lottoTicket.hasDuplicateNumber(bonusNumber) ? 1:0;
        return WinningRank.getRank(matchCount, bounceCount);
    }
}
