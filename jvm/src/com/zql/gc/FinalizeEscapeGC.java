package com.zql.gc;

/**
 * 对象在被划分到可被GC的 集合中后，是可以自我拯救的
 * 自救的机会只有一次，就是在执行finalize()方法时
 *
 * @author lawliet.L
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC instance = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法已执行");
        FinalizeEscapeGC.instance = this;
    }

    public static void main(String[] args) throws InterruptedException {
        instance = new FinalizeEscapeGC();

        // 模拟自救
        instance = null;
        System.gc();
        // 因为finalize方法的优先级特别低，所以让线程在这里等一会
        Thread.sleep(500);
        if (instance != null) {
            System.out.println("instance还活着");
        } else {
            System.out.println("instance已经死了");
        }
        // 上面的方法执行后会发现，finalize方法已经执行了，但是instance依然还活着，这是因为在finalize方法中将instance又重新赋值了
        // 但是由于一个对象的finalize方法最多只会被系统调用一次，所以下面的代码和上面一样，但是instance却已经死了
        instance = null;
        System.gc();
        // 因为finalize方法的优先级特别低，所以让线程在这里等一会
        Thread.sleep(500);
        if (instance != null) {
            System.out.println("instance还活着");
        } else {
            System.out.println("instance已经死了");
        }
    }
}
