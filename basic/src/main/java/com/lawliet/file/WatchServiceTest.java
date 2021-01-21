package com.lawliet.file;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author dell
 */
public class WatchServiceTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("F:\\zql\\idea_work\\Java\\basic\\src\\com\\lawliet\\file");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);
        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> pollEvent : watchKey.pollEvents()) {
                WatchEvent.Kind<?> eventKind = pollEvent.kind();
                String fileName = pollEvent.context().toString();
                System.out.println("触发的事件类型：" + eventKind + "======文件名称：" + fileName);
            }
            watchKey.reset();
        }
    }
}
