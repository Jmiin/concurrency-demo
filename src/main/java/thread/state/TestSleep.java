package thread.state;

/**
 * 模拟网络延时:放大问题的发生性
 *
 * @author JiangMin 2020/09/09 14:20
 */
public class TestSleep implements Runnable{

    //票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while(true){
            if (ticketNums <= 0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->获取了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep target = new TestSleep();
        new Thread(target,"小明").start();
        new Thread(target,"老师").start();
        new Thread(target,"黄牛").start();
    }

}
