package thread;

import java.lang.annotation.Target;
import java.util.concurrent.*;

import javafx.concurrent.Task;

/**
 * 实现Callable接口
 *
 * @author JiangMin 2020/09/08 9:37
 */
public class ImplCallable implements Callable<String> {


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return "Impl Callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         *
         * 这里是为了演示使用该方法，正常情况下是不允许的
         *
         *阿里巴巴开发规范：
         * 4. 【强制】 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这
         * 样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
         * 说明：Executors 返回的线程池对象的弊端如下：
         * 1） FixedThreadPool 和 SingleThreadPool：
         * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
         * 2） CachedThreadPool：
         * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
         */
        ImplCallable implCallable = new ImplCallable();
        Future<String> submit = executorService.submit(implCallable);
        System.out.println(submit.get());
        executorService.shutdown();
    }
}
