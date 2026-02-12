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
            LottoGame game = new LottoGame();

            int manualCount = purchaseManual(wallet, game);
            LottoTickets autoTickets = game.buyAuto(wallet);

            printPurchaseResult(manualCount, autoTickets.size(), game.getAllTickets());

            processWinning(game, wallet);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private Wallet initializeWallet() {
        Money purchaseAmount = inputView.inputMoney();
        return new Wallet(purchaseAmount);
    }

    private int purchaseManual(Wallet wallet, LottoGame game) {
        int manualCount = inputView.inputManualTicketCount();
        
        game.validateManualPurchaseCapability(wallet, manualCount);

        LottoTickets manualTickets = inputView.inputManualTickets(manualCount);
        game.buyManual(wallet, manualTickets);
        return manualCount;
    }

    private void printPurchaseResult(int manualCount, int autoCount, LottoTickets tickets) {
        outputView.printPurchaseCount(manualCount, autoCount);
        outputView.printTickets(tickets);
    }

    private void processWinning(LottoGame game, Wallet wallet) {
        WinningLotto winningLotto = createWinningLotto();
        WinningInfo winningInfo = game.calculateResult(winningLotto);
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