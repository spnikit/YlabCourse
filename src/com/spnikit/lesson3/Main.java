package com.spnikit.lesson3;

public class Main {

    public static void main(String[] args) {


        // Создание объекта game и вызов метода play с передачей writer-a для записи результата в XML файл
//            new Game().play(new XmlGameWriter("./test.xml"));

        // парсинг XML файла с получением объекта Gameplay с последующей его передачей в игру для производства повтора

        new Game().replay(new XmlGameReader("./temp.xml").getGameplay());

    }
}



