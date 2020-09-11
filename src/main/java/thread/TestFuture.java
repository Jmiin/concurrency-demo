package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Future ExecutorService
 * 运行程序的主机是12线程的，因此启动了12个线程，每次会同时执行12个task。
 *
 */
public class TestFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //匿名内部类声明
        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {

                long start = System.currentTimeMillis();
                Thread.sleep(100);
                long end = System.currentTimeMillis();

                long seed = end - start;
                System.out.println(Thread.currentThread().getName()+" seed=" + seed);

                return seed;
            }
        };

        List<Callable<Long>> tasks = new ArrayList<>();
        for(int i = 0; i < 24; i++) {
            tasks.add(callable);
        }

        int poolSize = Runtime.getRuntime().availableProcessors();
        System.out.println("poolSize=" + poolSize);
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        List<Future<Long>> futures = executorService.invokeAll(tasks);

        long result = 0;
        for (Future<Long> future : futures) {
            result += future.get();
        }
        System.out.println("result=" + result);

        executorService.shutdown();
    }
}
