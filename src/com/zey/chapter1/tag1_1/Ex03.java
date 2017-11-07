package com.zey.chapter1.tag1_1;

public class Ex03 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("请输入3个整数");
            return;
        }
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            if (a == b && b == c) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        } catch (NumberFormatException e) {
            System.out.println("请输入3个整数");
        }
    }
}
