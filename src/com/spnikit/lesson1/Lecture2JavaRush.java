package com.spnikit.lesson1;

import java.util.stream.IntStream;

public class Lecture2JavaRush {

    public static void main(String[] args) {

        /*
         * Создать объект типа Cat 2 раза.
         */
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();


        /*
         *Создать 3 объекта типа Dog (собака) и присвоить им имена "Max", "Bella", "Jack".
         */
        Dog dog1 = new Dog("Max");
        Dog dog2 = new Dog("Bella");
        Dog dog3 = new Dog("Jack");

        /*Напиши программу, которая выводит на экран надпись: «Мне так плохо! Хочу, чтобы все умерли!».
         */
        System.out.println("Мне так плохо! Хочу, чтобы все умерли!");

    }

    /*
     * Написать функцию, которая возвращает минимум из двух чисел.
     * */

    public int min(int num1, int num2) {
        if (num1 > num2) return num2;
        return num1;
    }

    /*
     * Написать функцию, которая возвращает максимум из двух чисел.
     * */
    public int max(int num1, int num2) {
        if (num1 > num2) return num1;
        return num2;
    }

    /*
     * Написать функцию, которая вычисляет минимум из трёх чисел.
     * */
    public int min(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }

    /*
    * Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
    * */

    public int min(int num1, int num2, int num3, int num4) {
        return Math.min(this.min(num1, num2, num3), num4);
    }

    /*
     * Написать функцию, которая выводит переданную строку на экран три раза, каждый раз с новой строки.
     * */

    public void print3times(String phrase) {
        IntStream.range(0, 3).forEach(n -> System.out.println(phrase));
    }

    /*
     * Написать функцию, которая выводит переданную строку (слово) на экран три раза, но в одной строке.
     *  Слова должны быть разделены пробелом и не должны сливаться в одно.
     * */

    public void print3timesWithoutNewLine(String phrase) {
        IntStream.range(0, 3).forEach(n -> System.out.print(phrase + " "));
    }
}


class Cat {
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}