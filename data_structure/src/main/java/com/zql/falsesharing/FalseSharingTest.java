package com.zql.falsesharing;

/**
 * 伪共享测试
 */
public class FalseSharingTest {

    public static void main(String[] args) {
        testSharingEffect();
    }

    /**
     * 测试利用缓存行达到共享的效果
     */
    private static void testSharingEffect() {
        // 初始化一个long数组，第一维数组设置的大一点，是为了凸显结果的差距
        long[][] arr = new long[1024 * 1024][];
        for (int i = 0; i < 1024 * 1024; i++) {
            // 一个缓存行可以存储64字节数据，long占8字节，所以设置数组长度为8
            arr[i] = new long[8];
            for (int j = 0; j < 8; j++) {
                arr[i][j] = 0L;
            }
        }

        // 利用缓存行的特性进行遍历
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 1024; i++) {
            for (int j = 0; j < 8; j++) {
                // 模拟进行一点计算
                // 这里取值时会利用到cache line的特性
                // cache line每次取数据都会当做一个整体来取，所以第二维的数组在取第一个值（占8字节）的时候，后面的56个字节（恰好为后面7个值）也会被加载
                // 所以，实际上，后面的7个值会直接从缓存行中获取，无须从主存中获取，这无疑会快很多。因为主存的获取效率比缓存行慢了接近2个数量级
                sum += arr[i][j];
            }
        }
        // 在我的电脑上多次执行，10-15毫秒
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");

        // 不利用缓存行特性进行遍历
        start = System.currentTimeMillis();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 1024 * 1024; j++) {
                // 这里取值时就无法利用缓存行特性，所以会频繁的访问主存，降低效率
                sum += arr[j][i];
            }
        }
        // 在我的电脑上多次执行，40-50毫秒
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

}
