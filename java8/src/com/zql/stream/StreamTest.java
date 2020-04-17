package com.zql.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lawliet.L
 */
public class StreamTest {

    public static void main(String[] args) {
        /*List<String> strings = Arrays.asList("abc1", "", "abc3", "abc4", "", "abc6", "abc7");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);*/

        // forEach，输出10个随机数
        /*Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/

        // map，输出元素对应的平方
        /*List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> squaresList = numbers.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(squaresList);*/

        // filter,获得空字符数量
        /*List<String> strings = Arrays.asList("abc1", "", "abc3", "abc4", "", "abc6", "abc7");
        Long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);*/

        // limit，获取指定数量的流
        /*Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/

        // sorted，对流排序
        /*Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);*/

        // parallel，并行程序
        /*List<String> strings = Arrays.asList("abc1", "", "abc3", "abc4", "", "abc6", "abc7");
        Long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);*/

        // Collectors，返回列表、字符串
        /*List<String> strings = Arrays.asList("abc1", "", "abc3", "abc4", "", "abc6", "abc7");
        List<String> filterList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("得到的列表：" + filterList);
        String filterString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("得到的字符串：" + filterString);*/

        // 统计
        /*List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大的数：" + statistics.getMax());
        System.out.println("最小的数：" + statistics.getMin());
        System.out.println("和：" + statistics.getSum());
        System.out.println("平均数：" + statistics.getAverage());*/

        Student student1 = new Student(1L, "张三", 23, "广东深圳");
        Student student2 = new Student(2L, "李四", 24, "广东广州");
        Student student3 = new Student(3L, "王五", 25, "广东河源");
        Student student4 = new Student(4L, "赵六", 26, "广东东莞");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
//        list.stream().forEach(System.out::println);

//        List<Student> collect = list.stream().filter(student -> "王五".equals(student.getName())).collect(Collectors.toList());
//        collect.stream().forEach(System.out::println);

        List<Student> collect = list.stream().map(student -> {
            Student s = new Student(student.getId(), "姓名：" + student.getName(), student.getAge(), "地址：" + student.getAddress());
            return s;
        }).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}
