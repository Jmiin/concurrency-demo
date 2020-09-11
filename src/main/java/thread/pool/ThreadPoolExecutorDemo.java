package thread.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author JiangMin 2020/09/11 9:04
 */
public class ThreadPoolExecutorDemo {

    // 最大核心线程数
    public static final int CORE_POOL_SIZE = 5;
    // 最大线程数
    public static final int MAXINUM_POOL_SIZE = 10;
    // 最大队列长度
    public static final int QUEUE_CAPACITY = 100;
    // 非核心线程闲置超时时间
    public static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXINUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //1. 线程总数量 < corePoolSize，无论线程是否空闲，都会新建一个核心线程执行
        //任务（让核心线程数量快速达到corePoolSize，在核心线程数量 <corePoolSize时）。
        // 注意，这一步需要获得全局锁。

        //2. 线程总数量 >= corePoolSize时，新来的线程任务会进入任务队列中等待，然
        //后空闲的核心线程会依次去缓存队列中取任务来执行（体现了线程复用）。

        //3. 当缓存队列满了，说明这个时候任务已经多到爆棚，需要一些“临时工”来执行
        //这些任务了。于是会创建非核心线程去执行这个任务。注意，这一步需要获得
        //全局锁。

        //4. 缓存队列满了， 且总线程数达到了maximumPoolSize，则会采取上面提到的
        //饱和策略进行处理。

        //最大任务数
        int maxTask = 201;
        for (int i = 0; i < maxTask; i++) {
            Runnable task = ()->{
                    System.out.println(Thread.currentThread().getName() + " Start.Time = " +new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("阻塞队列的长度："+workQueue.size());
                    System.out.println(Thread.currentThread().getName() + " End.Time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            };

            // 执行Runnable
            executor.execute(task);
        }
        executor.shutdown();
    }
}
