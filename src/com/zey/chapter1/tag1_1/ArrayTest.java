package com.zey.chapter1.tag1_1;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        double[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        a = reverseArray(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 数组反转
     * @param a
     * @return
     */
    public static double[] reverseArray(double[] a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }
        return a;
    }

}
