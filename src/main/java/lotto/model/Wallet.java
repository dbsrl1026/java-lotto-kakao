package lotto.model;

public class Wallet {
    private Money balance;
    private Money receipt;

    public Wallet(Money balance) {
        this.balance = balance;
        this.receipt = new Money(0);
    }

    public void pay(Money money) {
        this.balance = balance.minus(money);
        this.receipt = receipt.sum(money);
    }

    public boolean checkBalance(Money money){
        return !balance.isLessThan(money);
    }

    public Double Settlement(Money money) {
        if (receipt.equals(new Money(0))) {
            return 0.0;
        }
        Double rateOfReturn = money.division(receipt);
        receipt = new Money(0);
        balance = balance.sum(money);
        return rateOfReturn;

    }


}
