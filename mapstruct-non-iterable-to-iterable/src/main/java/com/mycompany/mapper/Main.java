package com.mycompany.mapper;

public class Main {

    public static void main(String[] args) {
        NonIterable nonIterable = new NonIterable();
        nonIterable.setMyInteger(1);
        nonIterable.setMyString("hello");

        Iterable iterable = SourceTargetMapper.MAPPER.toTarget(nonIterable);
        System.out.println(iterable.getMyIntegers().get(0));
        System.out.println(iterable.getMyStrings().get(0));
    }
}
