package thread.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全的集合
 *
 * @author JiangMin 2020/09/21 17:33
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }

        Thread.sleep(4000);
        System.out.println(list.size());
    }
}
