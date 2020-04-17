package com.zql.java9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Java9Application {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String str1 = "Not Present";
        Process process = processBuilder.start();
        ProcessHandle.Info info = process.info();
        System.out.printf("Process Id : %s%n",process.pid());
        System.out.printf("Command name : %s%n",info.command().orElse(str1));
        System.out.printf("Command line : %s%n",info.commandLine().orElse(str1));

        System.out.printf("Start time：%s%n",info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
            .toLocalDateTime().toString()).orElse(str1));

        System.out.printf("Arguments： %s%n",info.arguments().map(a -> Stream.of(a).collect(
            Collectors.joining(" "))).orElse(str1));

        System.out.printf("User：%s%n",info.user().orElse(str1));
        SpringApplication.run(Java9Application.class, args);
    }

}
