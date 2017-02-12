package com.dp.mingmi;

import java.util.concurrent.Callable;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class MiThreadCallable implements Callable {
    private String threadName;
    private int id;

    public MiThreadCallable(String threadName, int id) {
        this.threadName = threadName;
        this.id = id;
    }

    public Object call(){
        return id;

    }

}
