package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class Consumer implements Runnable {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.consumerQueue();
        }
    }
}
