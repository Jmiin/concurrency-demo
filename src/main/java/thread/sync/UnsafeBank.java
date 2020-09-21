package thread.sync;

/**
 * 线程不安全的同步
 *
 * @author JiangMin 2020/09/21 17:09
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account allMoney = new Account(100, "all money");

        WithDrawing a = new WithDrawing(allMoney, 50, "A");
        WithDrawing b = new WithDrawing(allMoney, 100, "B");

        a.start();
        b.start();
    }

}




class Account {
    // 余额
    int money;

    // 卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}




// 银行取钱
class WithDrawing extends Thread {


    // 账户
    Account account;

    // 取款
    int drawingMoney;

    // 手上余额
    int nowMoney;

    public WithDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    // 判断有没有钱
    @Override
    public void run() {

        if (account.money - drawingMoney <= 0) {
            System.out.println(Thread.currentThread().getName() + " Account has not enought money.");
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //logger.error("inputParams:{} and errorMessage:{}",null, e.getMessage(), e);

        }

        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name+"余额:"+account.money);
        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }
}
