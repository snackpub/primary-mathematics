package com.snackpub.test;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author snackpub
 * @date 2021/5/4
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> strs = new LinkedList<>();

        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");

        ListIterator<String> iterator = strs.listIterator();
        if (iterator.hasNext()) {
//            String next = iterator.next();
//            iterator.add("r"); // next 元素后面插入

            int i = iterator.nextIndex();
            String s = strs.get(i);
            System.out.println(s);
        }
        int i = iterator.nextIndex();
        String s = strs.get(i);

        strs.listIterator().forEachRemaining(System.out::println);

        String[] ops = new String[0];
        System.out.println(ops.length);
    }
}
