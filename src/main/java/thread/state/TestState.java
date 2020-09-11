package thread.state;

/**
 * 观察测试线程状态
 *
 * @author JiangMin 2020/09/09 14:51
 */
public class TestState implements Runnable {


    @Override
    public void run() {
//        for(int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("🆗");
        for (int i = 0; i < 1000; i++) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestState());
        //NEW
        System.out.println(thread.getState());
        thread.start();
        //RUNNABLE
        System.out.println(thread.getState());

        while (thread.getState()!=Thread.State.TERMINATED){
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
       // System.out.println(thread.getState());

    }
}
