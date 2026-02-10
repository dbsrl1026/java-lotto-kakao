package lotto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTicketListTest {


    @Test
    @DisplayName("제대로 생성돼는지")
    public void createLottoTicketList() {
        assertThatCode(() -> new LottoTicketList(List.of(
                createLottoTicket(List.of(1,2,3,4,5,6)),
                createLottoTicket(List.of(1,2,3,4,5,6)),
                createLottoTicket(List.of(1,2,3,4,5,6)),
                createLottoTicket(List.of(1,2,3,4,5,6)),
                createLottoTicket(List.of(1,2,3,4,5,6))
        )));
    }

    @Test
    @DisplayName("null값이어도 정상 초기화 되는지 검사")
    public void lottoTicketListIsNull() {
        assertThatCode(() -> new LottoTicketList(null));
    }



    public LottoTicket createLottoTicket(List<Integer> nums) {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(nums.get(0)),
                new LottoNumber(nums.get(1)),
                new LottoNumber(nums.get(2)),
                new LottoNumber(nums.get(3)),
                new LottoNumber(nums.get(4)),
                new LottoNumber(nums.get(5))
        );
        return new LottoTicket(lottoNumbers);
    }

}