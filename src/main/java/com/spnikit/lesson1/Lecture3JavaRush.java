package com.spnikit.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Lecture3JavaRush {
    public static void main(String[] args) throws IOException {
        /*
        * Вывести на экран произведение чисел от 1 до 10.
          Подсказка: будет три миллиона с хвостиком
        * */

        IntStream.range(1, 11)
                .reduce((int acc, int curr) -> acc * curr).ifPresent(System.out::println);

    /*
    *   Вывести на экран сумму чисел от 1 до 10 построчно:
        1
        3
        6
        10
    *
    * */
        IntStream.range(1, 11)
                .reduce((int acc, int curr) -> {
                    if (acc == 1) {
                        System.out.println(acc);
                        System.out.println(acc + curr);
                        return acc + curr;
                    }
                    System.out.println(acc + curr);
                    return acc + curr;
                });

    /*
    * Выведи на экран таблицу умножения 10 на 10 в следующем виде:
    1 2 3 …
    2 4 6 …
    3 6 9 …
    * */
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
            System.out.print(j * i + " ");
            }
            System.out.println("");
        }
        /*
        *Ввести с клавиатуры число и имя, вывести на экран строку:
        «имя» захватит мир через «число» лет. Му-ха-ха!
        * */
        System.out.println("Введите число: ");
        String number =  new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println("Введите имя: ");
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

        System.out.println(name + " захватит мир через " + number + " лет. Му-ха-ха!");


    }
}
