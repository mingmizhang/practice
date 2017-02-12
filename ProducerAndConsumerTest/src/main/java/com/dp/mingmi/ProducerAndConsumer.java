package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        Product product = new Product();
        Producer producer = new Producer(product);
        Thread producerThread=new Thread(producer);
        producerThread.start();
        Consumer consumer = new Consumer(product);
        Thread consumerThread=new Thread(consumer);
        consumerThread.start();

    }
}
