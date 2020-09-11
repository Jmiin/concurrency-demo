package thread.state;

/**
 * 线程礼让:礼让不一定成功
 *
 * @author JiangMin 2020/09/09 14:32
 */
public class TestYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start");
        //线程礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+" stop");
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();
        Thread a = new Thread(testYield, "a");
        Thread b = new Thread(testYield, "b");

        a.start();
        b.start();
    }
}
