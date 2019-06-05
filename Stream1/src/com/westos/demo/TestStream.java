package com.westos.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        //1,转成流
        Stream<Integer> stream1=list.stream();
        //2,过滤方法
        Stream<Integer> stream2=stream1.filter(i -> i%2 ==0);
        //各个元素*2   映射
        Stream<Integer> stream3=stream2.map((i) -> i*2);
        //收集结果
        List<Integer> list1=stream3.collect(Collectors.toList());
        System.out.println(list1);

       // List list=list.stream().filter().map().collect();
    }
}
