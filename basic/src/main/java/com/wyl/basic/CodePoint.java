package com.wyl.basic;

/**
 * cloud-study CodePoint
 *
 * <p>
 * TODO
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/12/2 20:01
 */
public class CodePoint {
    public static void main(String[] args) {
        String greeting = "Hello";
        int n = greeting.length();
        int cpuCount = greeting.codePointCount(0, greeting.length());
        System.out.println(n+"__"+cpuCount);
    }
}
