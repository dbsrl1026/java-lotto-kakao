package lotto;

public class LottoNumber {

    private final int num;

    public LottoNumber(int num) {
        if (num < 1 || num >45) {
            throw new RuntimeException("로또 번호는 1-45 사이 값이어야 합니다");
        }
        this.num = num;
    }

}
