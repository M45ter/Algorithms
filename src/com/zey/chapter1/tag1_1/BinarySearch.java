package com.zey.chapter1.tag1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] whitelist = In.readInts(args[0]);
        int[] whitelist = {7, 73, 87, 2, 98, 36, 46, 36, 35, 67, 95, 47, 43, 78, 28, 39, 89, 84, 74, 56, 34};
        //排序
        Arrays.sort(whitelist);
        //排序后数组
        System.out.println(Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
//            if (rank(key, whitelist) < 0)
//                StdOut.println(key);
            int index = rank(key, whitelist);
            StdOut.println(index);
        }
    }
}
