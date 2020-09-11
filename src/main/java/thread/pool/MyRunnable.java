package thread.pool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description
 *
 * @author JiangMin 2020/09/11 9:02
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " +new SimpleDateFormat("HH:mm:ss").format(new Date()));
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
