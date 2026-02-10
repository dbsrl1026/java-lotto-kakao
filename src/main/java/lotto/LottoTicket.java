package lotto;

import java.util.*;

public class LottoTicket {
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this(new TreeSet<>(lottoNumbers));
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers){
        if(!validate(lottoNumbers)){
            throw new RuntimeException("로또 티켓에는 6개의 번호가 필요합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    static boolean validate(Set<LottoNumber> lottoNumbers){
        return lottoNumbers.size() == 6;
    }
}
