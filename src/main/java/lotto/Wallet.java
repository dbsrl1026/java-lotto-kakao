package lotto;

public class Wallet {
    private Money balance;
    private Money receipt;

    public Wallet(Money balance) {
        if(balance.isDebt()) throw new RuntimeException("잔액은 항상 0원 이상이어야 합니다.");
        this.balance = balance;
    }

    public void change(Money money) {
        Money newBalance = balance.sum(money);
        if(newBalance.isDebt()) {
            throw new RuntimeException("잔액은 항상 0원 이상이어야 합니다.");
        }
        this.balance = newBalance;
        receipt = receipt.sum(money);
    }

    public boolean checkBalance(Money money){
        Money newBalance = balance.sum(money);
        return !newBalance.isDebt();
    }




}
