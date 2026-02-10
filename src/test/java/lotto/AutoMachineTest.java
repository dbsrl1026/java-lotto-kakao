package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AutoMachineTest {

    @Test
    @DisplayName("티켓 하나 발급")
    public void issueTicket(){
        Wallet wallet = new Wallet(new Money(3000));
        AutoMachine autoMachine = new AutoMachine();

        assertThat(autoMachine.issue(wallet))
                .isInstanceOf(LottoTicket.class);
    }

}