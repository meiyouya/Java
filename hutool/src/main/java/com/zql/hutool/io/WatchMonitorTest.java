package com.zql.hutool.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.watchers.DelayWatcher;

import java.io.File;

/**
 * @author dell
 */
public class WatchMonitorTest {

    public static void main(String[] args) {
        File file = FileUtil.file("./");
        /*WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
        watchMonitor.setWatcher(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> watchEvent, Path path) {
                Console.log("创建：{}  ----   {}", path, watchEvent.context());
            }

            @Override
            public void onModify(WatchEvent<?> watchEvent, Path path) {
                Console.log("修改：{}  ----   {}", path, watchEvent.context());
            }

            @Override
            public void onDelete(WatchEvent<?> watchEvent, Path path) {
                Console.log("删除：{}  ----   {}", path, watchEvent.context());
            }

            @Override
            public void onOverflow(WatchEvent<?> watchEvent, Path path) {
                Console.log("Overflow：{}  ----   {}", path, watchEvent.context());
            }
        });
        watchMonitor.setMaxDepth(3);
        watchMonitor.start();*/

        // 这种方式会监听所有事件，但是事件的处理函数可以选择性重写
        /*WatchMonitor.createAll(file, new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                super.onModify(event, currentPath);
            }
        }).start();*/

        // 通过DelayWatcher可以设置合并指定时间内的所有事件，时间单位是毫秒
        WatchMonitor.createAll(file, new DelayWatcher(new SimpleWatcher(), 500)).start();
    }
}
