package thread.Daemon;

/**
 * 守护线程（Daemon）
 *
 * @author JiangMin 2020/09/21 16:45
 */
public class TestDaemon {

    public static void main(String[] args) {
        Person you = new Person();
        God god = new God();
        Thread thread1 = new Thread(god);
        thread1.setDaemon(true);
        thread1.start();
        Thread thread2 = new Thread(you);
        thread2.start();
    }
}

// god
class God implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("looking...");
        }
    }
}




// people
class Person implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 356000; i++) {
            System.out.println("god watch you");
        }
        System.out.println("goodbye!");
    }
}

