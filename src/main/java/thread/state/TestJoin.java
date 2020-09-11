package thread.state;

/**
 * 合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞
 * 可以理解为插队
 *
 * @author JiangMin 2020/09/09 14:39
 */
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("插队的线程"+Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 200){
                thread.join();
            }
            System.out.println(Thread.currentThread().getName()+i);

        }
    }
}
