package com.tzzh.taskrwzl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: PCJ
 * @Create: 2022-04-14 16:09
 * @Description:
 **/
@Slf4j
@EnableAsync
@Configuration
public class ExecutorConfig {

    @Value("${task.pool.corePoolSize}")
    private int corePoolSize;
    @Value("${task.pool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${task.pool.queueCapacity}")
    private int queueCapacity;
    @Value("${task.pool.keepAliveSeconds}")
    private int keepAliveSeconds;
    @Value("${task.pool.threadNamePrefix}")
    private String threadNamePrefix;

    @Bean("asyncServiceExecutor")
    public Executor asyncServiceExecutor(){
        log.info("------ asyncServiceExecutor -------");
        VisibleThreadPoolTaskExecutor executor = new VisibleThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(corePoolSize);
        //最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //队列大小
        executor.setQueueCapacity(queueCapacity);
        //空闲时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        /**
         * 任务拒绝处理器，两种情况会拒绝处理任务
         * rejection-policy：当线程数已经达到maxPoolSize，切队列已满，会拒绝新任务
         * CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化
        executor.initialize();
        return executor;
    }


}
