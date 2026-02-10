package lotto;

public class Money {

    private final int money;
    public Money(int money) {
        if(money < 0) throw new RuntimeException("돈은 항상 0원 이상이어야 합니다.");
        this.money = money;
    }

}
