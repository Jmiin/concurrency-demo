package thread.state;

/**
 * 线程停止
 *      1.建议线程正常停止--->利用次数，不建议死循环。
 *      2.建议使用标志位---> 设置一个标准位
 *      3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
 *
 * @author JiangMin 2020/09/08 14:34
 */
public class TestStop  implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run .... Thread "+i++ );
        }
    }

    public void stop(){
        this.flag  = false;
    }

    public static void main(String[] args) {
        TestStop target = new TestStop();
        new Thread(target).start();

        //注意：不要显示的创建线程，请使用线程池
        for (int i = 0; i < 1000; i++) {
            System.out.println("main "+i);
            if(i==900){
                target.stop();
                System.out.println("线程停止");
            }
        }
    }
}
