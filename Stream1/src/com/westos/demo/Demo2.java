package com.westos.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        List<String[]> list=new ArrayList<>();
        list.add(new String[]{"张三","王五"});
        list.add(new String[]{"张三","王五2"});

        //1,flatmap 遍历                                    字符串数字变为0.
        List<String> collect = list.stream().flatMap(strings -> stream(strings)).collect(toList());
        System.out.println(collect);

        //2,遍历 forEach 接受一个consumer
        collect.forEach((a) ->{
            System.out.println(a);
        });

        //3,map的遍历 接受一个双参数的consumer
        Map<String,String > map=new HashMap<>();
        map.put("1","张");
        map.put("2","李");
        map.forEach((key,value) -> {
            System.out.println(key+"------"+value);
        });
        //求个数
        System.out.println(list.stream().count());
        //去除重复
        System.out.println(collect.stream().distinct().collect(toList()));
        //数组流
        int[] array={3,22,5,3,5,67,3,134,};
        List<Integer>  list2=asList(2,3,4,6,34,21,3121,3,5);
        System.out.println(Arrays.stream(array).max());
        //文件流读取
        Files.lines(Paths.get("1.txt")).forEach((s) -> System.out.println(s));
        //使用生产者的接口来随机生成几个整数
        Random r=new Random();
        Stream.generate(() -> r.nextInt(100)).limit(5).forEach(s -> System.out.println(s));//一个参数，没有返回结果
        Stream.generate(() -> r.nextInt(100)).limit(5).forEach(System.out::println);
        //格式：
        //   对象:: 方法名
        //   类名:: 静态方法名
        Arrays.stream(array).filter(i ->i % 3 == 0);//一个参数，返回结果是boolean。
        System.out.println(list2.stream().filter(Demo2::aa).collect(toList()));

        //类名:: new
        Stream.generate(Student::new).limit(5).forEach(x -> System.out.println(x));

    }

    public static boolean aa(Integer x){
        //代码多
        return x % 2 == 0;
    }
}
