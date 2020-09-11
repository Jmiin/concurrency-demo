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
        testUncatchException();
        diffPriority();
    }

    public static void testUncatchException() {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        // 这个线程是threadGroup1的⼀员
        Thread thread1 = new Thread(threadGroup1, ()-> {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            });
        thread1.start();
    }

    public static void diffPriority() {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级" + threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级" + thread.getPriority());
    }
}
