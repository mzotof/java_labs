//Реализовать многопоточное приложение “Банк”. Имеется банковский счет. Сделать синхронным пополнение
// и снятие денежных средств на счет/со счет случайной суммой. При каждой операции (пополнения или снятие)
// вывести текущий баланс счета. В том случае, если денежных средств недостаточно – вывести сообщение.

import java.util.Random;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение: " + String.format("%.2f",amount)
                + ", баланс: " + String.format("%.2f",balance));
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снятие: " + String.format("%.2f",amount)
                    + ", баланс: " + String.format("%.2f",balance));
        } else {
            System.out.println("Недостаточно средств для снятия: " + String.format("%.2f",amount)
                    + ", баланс: " + String.format("%.2f",balance));
        }
    }
}

class BankTransaction implements Runnable {
    private final BankAccount account;

    public BankTransaction(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            // Случайная сумма для операции
            double amount = random.nextDouble() * 1000;

            // С вероятностью 50% проводим либо операцию пополнения, либо операцию снятия
            if (random.nextBoolean()) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }

            // Задержка между операциями
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ex1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread producerThread = new Thread(new BankTransaction(account));
        Thread consumerThread = new Thread(new BankTransaction(account));

        producerThread.start();
        consumerThread.start();
    }
}
