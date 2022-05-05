package com.tzzh.taskrwzl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: PCJ
 * @Create: 2022-04-14 16:14
 * @Description: 创建ThreadPoolTaskExecutor的子类，打印线程情况
 **/
public class VisibleThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    /**
     * 全局定义日志打印变量
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VisibleThreadPoolTaskExecutor.class);


    private void showThreadPoolInfo(String prefix){

        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();
        //判断
        if (threadPoolExecutor == null) {
            return;
        }
        //打印线程池使用日志
        LOGGER.info("{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(),
                prefix,
                //任务总数
                threadPoolExecutor.getTaskCount(),
                //已完成任务数
                threadPoolExecutor.getCompletedTaskCount(),
                //活跃线程数
                threadPoolExecutor.getActiveCount(),
                //队列大小
                threadPoolExecutor.getQueue().size()
        );
    }

    @Override
    public void execute(Runnable task) {
        showThreadPoolInfo("1. do execute");
        super.execute(task);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        showThreadPoolInfo("2. do execute");
        super.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        showThreadPoolInfo("1. do submit");
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showThreadPoolInfo("2. do submit");
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        showThreadPoolInfo("1. do submitListenable");
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        showThreadPoolInfo("2. do submitListenable");
        return super.submitListenable(task);
    }
}
