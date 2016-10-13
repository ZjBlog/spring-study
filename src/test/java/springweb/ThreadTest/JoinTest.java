package springweb.ThreadTest;

import org.junit.Test;

public class JoinTest implements Runnable {

    public static int a = 0;

    @Override
    public void run() {
        for (int k = 0; k < 5; k++) {
            a = a + 1;
        }
    }

    @Test
    public void test() throws Exception {
        Runnable r = new JoinTest();
        Thread t = new Thread(r);
        t.start();
        t.join();// 知道t线程完成
        System.out.println("1222222222");
        System.out.println(a);
    }
}