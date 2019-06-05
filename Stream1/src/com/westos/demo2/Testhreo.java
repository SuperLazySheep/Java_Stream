package com.westos.demo2;

import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Testhreo {
    public static void main(String[] args) throws IOException {
        //1,读取文件
        List<Hero> list = Files.lines(Paths.get("heroes.txt")).map((line) -> {
            String[] strs = line.split("\t");
            return new Hero(
                    Integer.parseInt(strs[0]),
                    strs[1],
                    strs[2],
                    strs[3],
                    Integer.parseInt(strs[4]),
                    Integer.parseInt(strs[5]),
                    Integer.parseInt(strs[6])
            );
        }).collect(Collectors.toList());

        //2,找出武力值前三的人名；
        List<String> list1 = list.stream().sorted((a, b) -> b.getPower() - a.getPower()).limit(3).map((h) -> h.getName()).collect(Collectors.toList());
        System.out.println(list1);

        //3,找出武力前三并列的人
        Set<Integer> set = list.stream().map((h) -> h.getPower()).distinct().sorted((a, b) -> b - a).limit(3).collect(Collectors.toSet());
        List<String> list2 = list.stream().filter((h) -> set.contains(h.getPower())).map((h) -> h.getName()).collect(Collectors.toList());
        System.out.println(list2);

        //根据年龄段分组 0~20,21~40，41~60,6以上
        Map<String, List<Hero>> collect = list.stream().collect(Collectors.groupingBy((h) -> h.ageRange()));
        collect.forEach((key,value) ->{
            List<String> names = value.stream().map(h -> h.getName()).collect(Collectors.toList());
            System.out.println(key +" "+names);
        });
        //分组 ，求个数
        //用的是下游收集器
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy((h) -> h.getLoc(), Collectors.counting()));
        collect1.forEach((key,value) -> {
            System.out.println(key+" "+ value);
        });

        //并行计算
        List<Integer> list4=Arrays.asList(1,2,4,3,5,6,7,8,9,10);
        int sum = list4.parallelStream().mapToInt(a -> a).sum();
        System.out.println(sum);
    }
}
