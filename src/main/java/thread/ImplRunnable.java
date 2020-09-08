package thread;

/**
 * 实现Runnable接口
 *
 * @author JiangMin 2020/09/08 9:32
 */
public class ImplRunnable {

    public static void main(String[] args) {
        new Thread(()-> System.out.println("Impl Runnable Thread")).start();
    }

}
