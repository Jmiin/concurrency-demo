package thread.group;

/**
 * 线程组测试
 *
 * @author JiangMin 2020/09/11 9:38
 */
public class ThreadDemo {
     /*
     ThreadGroup和Thread的关系就如同他们的字面意思一样简单粗暴，每个Thread必
     然存在于⼀个ThreadGroup中，Thread不能独立于ThreadGroup存在。执行main()
     方法线程的名字是main，如果在new Thread时没有显式指定，那么默认将父线程
     （当前执行new Thread的线程）线程组设置为自己的线程组。
      */

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("当前线程" + Thread.currentThread().getName() + "的线程组的名字为："
                            + Thread.currentThread().getThreadGroup().getName());
        }).start();

        System.out.println("main线程的线程组的名字为："
                        + Thread.currentThread().getThreadGroup().getName());
    }
}
