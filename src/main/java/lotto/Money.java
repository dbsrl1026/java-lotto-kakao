package lotto;

public class Money {

    private final int value;
    public Money(int money) {
        if(!validateMoney(money)) throw new RuntimeException("돈은 항상 0원 이상이어야 합니다.");
        this.value = money;
    }


    public static boolean validateMoney(int money) {
        return money >= 0;
    }

    public Money sum(Money m2) {
        return new Money(this.value + m2.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money money = (Money) obj;
        return this.value == money.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

}
