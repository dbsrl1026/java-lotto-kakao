package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            Wallet wallet = initializeWallet();
            LottoTickets manualTickets = purchaseManualTickets(wallet);
            int manualCount = manualTickets.size();
            LottoTickets autoTickets = purchaseAutoTickets(wallet);

            LottoTickets allTickets = mergeTickets(manualTickets, autoTickets);
            printPurchaseResult(manualCount, autoTickets.size(), allTickets);

            processWinning(allTickets, wallet);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private Wallet initializeWallet() {
        Money purchaseAmount = inputView.inputMoney();
        return new Wallet(purchaseAmount);
    }

    private LottoTickets purchaseManualTickets(Wallet wallet) {
        int manualCount = inputView.inputManualTicketCount();
        Money manualPrice = AutoMachine.LOTTO_PRICE.multiple(manualCount);
        wallet.pay(manualPrice);

        return inputView.inputManualTickets(manualCount);
    }

    private LottoTickets purchaseAutoTickets(Wallet wallet) {
        AutoMachine autoMachine = new AutoMachine();
        return autoMachine.allIn(wallet);
    }

    private LottoTickets mergeTickets(LottoTickets manual, LottoTickets auto) {
        manual.addAll(auto);
        return manual;
    }

    private void printPurchaseResult(int manualCount, int autoCount, LottoTickets tickets) {
        outputView.printPurchaseCount(manualCount, autoCount);
        outputView.printTickets(tickets);
    }

    private void processWinning(LottoTickets tickets, Wallet wallet) {
        WinningLotto winningLotto = createWinningLotto();
        WinningInfo winningInfo = tickets.winningResult(winningLotto);
        outputView.printStatistics(winningInfo);

        Money totalPrize = winningInfo.getTotalPrice();
        double rateOfReturn = wallet.Settlement(totalPrize);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private WinningLotto createWinningLotto() {
        LottoTicket winningNumbers = inputView.inputWinningNumbers();
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
