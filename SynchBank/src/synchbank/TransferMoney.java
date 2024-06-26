/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchbank;

import java.util.Random;

public class TransferMoney implements Runnable {
    private Bank bank;
    private int fromAcc;
    private double maxAmount;
    private int delay = 1000;

    public TransferMoney(Bank bank, int fromAcc, double maxAmount) {
        this.bank = bank;
        this.fromAcc = fromAcc;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        Random rd = new Random();
        int toAcc = 0;
        double amount;
        try {
            while (true) {
                do {
                    toAcc = rd.nextInt(bank.size());
                } while (toAcc == fromAcc);
                amount = rd.nextDouble() * maxAmount;
                bank.transfer(fromAcc, toAcc, amount);
                Thread.sleep(rd.nextInt(delay));
            }
        } catch (InterruptedException ex) {
            System.out.println("Giao dich chuyen tien tu account " + fromAcc + " sang account " + toAcc + " bi gian doan");
        }
    }
}
