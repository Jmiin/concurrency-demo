package thread.priority;

/**
 * 线程的优先级 1~10
 *      线程优先级低只是意味着获得调度的概率低
 *      并不是优先级低就会真的比优先级高的后调度
 *      全看CPU的调度
 *
 * @author JiangMin 2020/09/09 15:08
 */
public class TestPriority   {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
        Priority target = new Priority();
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(target);
        Thread t4 = new Thread(target);
        Thread t5 = new Thread(target);
        Thread t6 = new Thread(target);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

//        t5.setPriority(-1);
//        t5.start();
//
//        t6.setPriority(11);
//        t6.start();
    }
}

class Priority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}