import java.util.Random;
import synchbank.Bank;
import synchbank.TransferMoney;




public class SynchBank {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(100, 1000);
        int size = bank.size();
        for (int i = 0; i < size; i++) {
            TransferMoney transferMoney = new TransferMoney(bank, i, 1000);
            Thread thread = new Thread(transferMoney);
            thread.start();
        }
    }
}
