//Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель.
// Пока производитель не поставит на склад продукт, покупатель не может его забрать. Реализовать
// приход товара от производителя в магазин случайным числом. В том случае, если товара в магазине
// не хватает – вывести сообщение.

import java.util.Random;

class Store {
    private int products = 0;
    private final int maxProducts = 10;
    private final int minProducts = 1;

    public synchronized void get() {
        Random random = new Random();
        int newProducts = random.nextInt(maxProducts - minProducts + 1) + minProducts;
        while (products < newProducts) {
            System.out.println("Покупатель не может купить " + newProducts + " товаров, так как на складе лежит " + products + " товаров");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products -= newProducts;
        System.out.println("Покупатель купил " + newProducts + " товаров");
        System.out.println("Товаров на складе: " + products);
        notify();
    }

    public synchronized void put() {
        Random random = new Random();
        int newProducts = random.nextInt(maxProducts - minProducts + 1) + minProducts;

        products += newProducts;
        System.out.println("Производитель поставил " + newProducts + " товаров");
        notify();
    }
}

class Producer implements Runnable {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.put();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.get();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ex3 {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}