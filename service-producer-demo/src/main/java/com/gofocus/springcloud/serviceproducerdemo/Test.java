package com.gofocus.springcloud.serviceproducerdemo;

/**
 * @Author: GoFocus
 * @Date: 2020-09-07 15:39
 * @Description:
 */
public class Test {

    private static int a[] = new int[]{-1, 0, 0, 0, 6, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//    private static int a[] = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) {
        System.out.println("foo(a, 1, 5) = " + foo(a, 2, 8));
        System.out.println("foo(a, 1, 5) = " + foo(a, 2, 9));
        System.out.println("foo(a, 1, 5) = " + foo(a, 2, 10));
    }

    private static int foo(int[] arr, int i, int n) {
        if (i == n - 1) {
            return a[i];
        } else {
            int tmp = foo(arr, i + 1, n);
            if (tmp < a[i]) {
                return a[i];
            } else {
                return tmp;
            }

        }
    }

}
