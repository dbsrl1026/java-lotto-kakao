package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoMachine {


    private final List<LottoNumber> numberList;
    public static final int LOTTO_PRICE = 1000;

    public AutoMachine() {
        numberList = new ArrayList<>();
        for(int i=LottoNumber.START_NUMBER; i<=LottoNumber.END_NUMBER; i++){
            numberList.add(new LottoNumber(i));
        }
    }

    public LottoTicket issue(Wallet wallet) {
        wallet.change(new Money(-LOTTO_PRICE));
        Collections.shuffle(numberList);
        return new LottoTicket(numberList.subList(0,6));
    }
}
