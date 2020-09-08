package thread;

/**
 * 继承Thread
 *
 * @author JiangMin 2020/09/08 9:24
 */
public class ExtendsThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new ThreadDemo());
        thread.start();
    }

    static class ThreadDemo extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }
}
