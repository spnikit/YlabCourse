package com.spnikit.lesson1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {

    static final Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    static int fibRecursion(int number) {
        if (number <= 1) {
            return number;
        }

        return fibRecursion(number - 2) + fibRecursion(number - 1);

    }

    static int fibWithLoop(int number) {
        int nPrev, nCurrent, result = 0;

        if (number <= 1) {
            return number;
        }

        nPrev = 0;
        nCurrent = 1;

        for (int i = 1; i < number; i++) {
            result = nPrev + nCurrent;
            nPrev = nCurrent;
            nCurrent = result;
        }

        return result;
    }

    static int fibWithArrAndLoop(int number) {
        int[] arr = new int[number + 2];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= number; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[number];
    }

    static int fibWithCache(int number) {
        int first, second;

        if (number <= 1) {
            return number;
        }

        if (cache.containsKey(number - 1)) {
            first = cache.get(number - 1);
        } else {
            first = fibWithCache(number - 1);
        }
        if (cache.containsKey(number - 2)) {
            second = cache.get(number - 2);
        } else {
            second = fibWithCache(number - 2);
        }

        cache.put(number, first + second);

        return first + second;
    }

    public static void main(String[] args) {


        IntStream.range(0, 10).forEach(x -> System.out.print(fibRecursion(x) + " "));
        System.out.println("- Recursion");
        IntStream.range(0, 10).forEach(x -> System.out.print(fibWithLoop(x) + " "));
        System.out.println("- Loop");
        IntStream.range(0, 10).forEach(x -> System.out.print(fibWithArrAndLoop(x) + " "));
        System.out.println("- Array");
        IntStream.range(0, 10).forEach(x -> System.out.print(fibWithCache(x) + " "));
        System.out.println("- Cache");
    }

}

