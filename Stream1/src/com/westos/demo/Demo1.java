package com.westos.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Demo1 {
    public static void main(String [] args){
        List<Integer> list= Arrays.asList(1,2,3,4,5);
//        System.out.println(exec(list,new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer%2==0;
//            }
//        }));
        //用的是lanmda表达式返回返回筛选后的新集合。（策略模式）
        System.out.println(exec(list,i -> i%2==0));
    }

    private static List<Integer> exec(List<Integer> list,Predicate<Integer> p) {
        List<Integer> list2= new ArrayList<>();
        for (Integer i:list) {
                if(p.test(i)){
                  list2.add(i);
                }
        }
        return list2;
    }
}
