package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @Test
    @DisplayName("게임 생성")
    public void createGame() {
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("수동 구매")
    public void buyManual() {
        LottoGame game = new LottoGame();
        Wallet wallet = new Wallet(new Money(5000));
        LottoTickets manualTickets = new LottoTickets(List.of(new LottoTicket(1,2,3,4,5,6)));
        
        game.buyManual(wallet, manualTickets);
        
        assertThat(game.getAllTickets().size()).isEqualTo(1);
        assertThat(wallet.checkBalance(new Money(4000))).isTrue();
    }

    @Test
    @DisplayName("자동 구매")
    public void buyAuto() {
        LottoGame game = new LottoGame();
        Wallet wallet = new Wallet(new Money(2000));
        
        LottoTickets autoTickets = game.buyAuto(wallet);
        
        assertThat(autoTickets.size()).isEqualTo(2);
        assertThat(game.getAllTickets().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 구매 금액 부족 시 예외 발생")
    public void validateManualPurchaseFail() {
        LottoGame game = new LottoGame();
        Wallet wallet = new Wallet(new Money(1000));
        
        assertThatThrownBy(() -> game.validateManualPurchaseCapability(wallet, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매 금액이 보유 금액보다 클 수 없습니다.");
    }
}
