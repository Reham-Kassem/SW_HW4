

public class eWallet {
    private double Balance;

    public eWallet() {
        Balance = 0;
    }

    public void withdraw(int amount_of_money) {
        if (amount_of_money <= Balance) {
            Balance -= amount_of_money;
            System.out.println("process is done");
        } else {
            System.out.println("There is not enough balance");
        }
    }

    public void deposit(int amount_of_money) {
        Balance += amount_of_money;
    }

    public boolean transform(int amount, Player aPlayer) {
        if (Balance < amount) {
            return false;
        } else {
            eWallet ewallet = aPlayer.getewallet();
            ewallet.deposit(amount);
            Balance -= amount;
            return true;
        }
    }

    public boolean transform(int amount, Playgroundowner anOwner) {
        if (Balance < amount) {
            return false;
        } else {
            eWallet ewallet = anOwner.getewallet();
            ewallet.deposit(amount);
            Balance -= amount;
            return true;
        }
    }
}
