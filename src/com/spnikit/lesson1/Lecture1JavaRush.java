package com.spnikit.lesson1;

import java.util.stream.IntStream;

public class Lecture1JavaRush {

    public static void main(String[] args) {
        /*
         * 	Объявите переменные name1, name2, name3 типа String.
         *  Сразу же в строке объявления присвойте им какие-нибудь значения.
         *  Значениями могут быть любые строки.
         * */

        String name1 = "name1";
        String name2 = "name2";
        String name3 = "name3";

        /*
         * Напиши программу, которая выводит на экран надпись:
         *  «Когда я вырасту, то хочу быть паровым экскаватором!» 10 раз.
         * */

        IntStream.range(0, 10).forEach((num) -> System.out.println("Когда я вырасту, то хочу быть паровым экскаватором!"));

        /*
         * Раскоментируйте часть кода, чтобы на экран вывелось сообщение "Happy New Year"
         * */

        //System.out.println("Happy New Year"); Типа расскоментировал ->
        System.out.println("Happy New Year");

        /*
         * Внесите изменения в программу, чтобы переменная s была равна 5, t была равна 6, а x равна 7.
         *  Программа должна компилироваться.
         * */
        int s = 5;
        int t = 6;
        int x = 7;

    }
}
