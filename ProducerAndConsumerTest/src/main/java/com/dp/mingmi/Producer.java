package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class Producer implements Runnable {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            ProductInfo productInfo = new ProductInfo("", i);
            product.productQueue(productInfo);
        }
    }
}
