package com.westos.demo;

import java.util.*;
import java.util.stream.Collectors;

public class TestStudent {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("张", "男", "北京"),
                new Student("lli", "女", "西安"),
                new Student("送", "男", "上海"),
                new Student("张", "女", "西安"),
                new Student("张", "男", "北京")
        );

        Map<String, List<Student>> map = new HashMap<>();

        //根据student的属性,来划分list
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy((student) -> {
            return student.getSex();
        }));
        System.out.println(collect);
    }

    public static void demo() {
        //把包装类型的 流变成基本类型的流
        List<Integer> integers = new ArrayList<>();
        integers.stream().mapToInt((Integer value) -> value.intValue()).average();
    }
}