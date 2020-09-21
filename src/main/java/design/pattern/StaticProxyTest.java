package design.pattern;

/**
 * description
 *
 * @author JiangMin 2020/09/08 11:01
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        new TureYou(new You()).happyStudy();
    }


}

//学习
interface Study{
    void happyStudy();
}

//真实的对象
class You implements Study{

    @Override
    public void happyStudy() {
        System.out.println("玩手机");
    }
}

//代理的对象
class TureYou implements Study{

    private Study target;

    public TureYou(Study target){
        this.target = target;
    }

    @Override
    public void happyStudy() {
        before();
        target.happyStudy();
        after();
    }

    private void after() {
        System.out.println("学习后，后悔打开手机");
    }

    private void before() {
        System.out.println("学习前，打开手机");
    }
}

