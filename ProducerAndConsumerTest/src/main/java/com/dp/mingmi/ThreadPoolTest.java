package com.dp.mingmi;

import java.util.concurrent.*;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Product product = new Product();
//        Producer producer = new Producer(product);
//        ExecutorService executorService= Executors.newFixedThreadPool(2);
//        executorService.submit(producer);
        //testRunnablePool();
        //testCallablePool();
        testCallablePool2();

    }


    public static void testRunnablePool(){
        MiThreadPool miThreadPool=new MiThreadPool();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(miThreadPool);
        executorService.shutdown();
    }

    public static void testCallablePool() throws ExecutionException, InterruptedException {
        MiThreadCallable miThreadCallable=new MiThreadCallable("mingmi",1);
        FutureTask<Integer> futureTask=new FutureTask<Integer>(miThreadCallable);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    public static void testCallablePool2() throws ExecutionException, InterruptedException {
        MiThreadCallable miThreadCallable=new MiThreadCallable("mingmi",2);
        MiThreadCallable miThreadCallable2=new MiThreadCallable("mingmi",4);
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Future<Integer> result=executorService.submit(miThreadCallable);
        Future<Integer> result2=executorService.submit(miThreadCallable2);
        System.out.println(result.get());
        System.out.println(result2.get());
        //FutureTask<Integer> futureTask=new FutureTask<Integer>(miThreadCallable);
        //executorService.submit(futureTask);
        //System.out.println(futureTask.get());
        executorService.shutdown();

    }
}
