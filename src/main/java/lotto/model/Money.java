package lotto.model;

public class Money {
    private final int value;

    public Money(int money) {
        if (money < 0) {
            throw new RuntimeException("금액은 0원 이상이어야 합니다.");
        }
        this.value = money;
    }

    public Money sum(Money m2) {
        return new Money(this.value + m2.value);
    }

    public Money minus(Money m2) {
        if (this.value < m2.value) {
            throw new RuntimeException("잔액이 부족합니다.");
        }
        return new Money(this.value - m2.value);
    }

    public Double division(Money m2) {
        if (m2.value == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return  (double) this.value / m2.value;
    }

    public Money multiple(int count){
        return new Money(value*count);
    }

    public int getValue() {
        return value;
    }

    public boolean isLessThan(Money other) {
        return this.value < other.value;
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
