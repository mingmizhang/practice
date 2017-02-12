package com.dp.mingmi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class Product {
    //to ensure the safety of value operation
    private AtomicInteger index=new AtomicInteger(0);
    private ProductInfo[] productInfos = new ProductInfo[6];

    public synchronized void productQueue(ProductInfo productInfo) {
        try {
            while (index.get()==6) {
                this.wait();
            }
            index.getAndIncrement();
            System.out.println("正在生产"+index.get());

            productInfos[index.get()-1] = productInfo;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void consumerQueue() {
        try {
            while (index.get()==0) {
                this.wait();
            }
            System.out.println("正在消费"+index.get());
            index.getAndDecrement();
            this.notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return productInfo;
    }


}
