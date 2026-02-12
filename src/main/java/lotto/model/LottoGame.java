package lotto.model;

public class LottoGame {
    private final LottoTickets tickets;
    private final AutoMachine autoMachine;

    public LottoGame() {
        this.tickets = new LottoTickets();
        this.autoMachine = new AutoMachine();
    }

    public void buyManual(Wallet wallet, LottoTickets manualTickets) {
        Money manualPrice = AutoMachine.LOTTO_PRICE.multiple(manualTickets.size());
        wallet.pay(manualPrice);
        tickets.addAll(manualTickets);
    }

    public void validateManualPurchaseCapability(Wallet wallet, int count) {
        Money price = AutoMachine.LOTTO_PRICE.multiple(count);
        if (!wallet.checkBalance(price)) {
            throw new IllegalArgumentException("수동 구매 금액이 보유 금액보다 클 수 없습니다.");
        }
    }

    public LottoTickets buyAuto(Wallet wallet) {
        LottoTickets autoTickets = autoMachine.allIn(wallet);
        tickets.addAll(autoTickets);
        return autoTickets;
    }

    public LottoTickets getAllTickets() {
        return tickets;
    }

    public WinningInfo calculateResult(WinningLotto winningLotto) {
        return tickets.winningResult(winningLotto);
    }
}
