/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchbank;

public class Bank {
    private double[] accounts;

    public Bank(int n, double initBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initBalance;
        }
    }

    public synchronized int size() {
        return accounts.length;
    }

    public synchronized double getTotalBalance() {
        double total = 0;
        for (double balance : accounts) {
            total += balance;
        }
        return total;
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            System.out.println(Thread.currentThread().getName() + " doi du tien");
            wait();
        }
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.println("Chuyen " + amount + " tu account " + from + " sang account " + to);
        System.out.println("Tong tien cua cac account: " + getTotalBalance());
        notifyAll();
    }
}
