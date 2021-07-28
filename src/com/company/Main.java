package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
// на входе строка - сложить 2 числа. вроде через пробел, но это не точно.
// оба числа до 10
// они могут быть римские и арабские, но складывать и то и то вместе нельзя.
// план такой: проверяем что в строке нет и того и того
// проверяем типы выражений.
// выдаём результат или исключение.

public class Main {
    public enum RIM {I,II,III,IV,V,VI,VII,VIII,IX,X};
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    public final static String arabToRome(int number) {
        int chislo =  map.floorKey(number);
        if ( number == chislo ) {
            return map.get(number);
        }
        return map.get(chislo) + arabToRome(number-chislo);
    }
    public static boolean isArabic(String s) throws IOException, Exception {
        if (s.equals("1")) {return true;}
        if (s.equals("2")) {return true;}
        if (s.equals("3")) {return true;}
        if (s.equals("4")) {return true;}
        if (s.equals("5")) {return true;}
        if (s.equals("6")) {return true;}
        if (s.equals("7")) {return true;}
        if (s.equals("8")) {return true;}
        if (s.equals("9")) {return true;}
        if (s.equals("10")) {return true;}

        return false;
    }
    public static boolean isRimic(String s) throws IOException, Exception {
        if (s.equals("I")) {return true;}
        if (s.equals("II")) {return true;}
        if (s.equals("III")) {return true;}
        if (s.equals("IV")) {return true;}
        if (s.equals("V")) {return true;}
        if (s.equals("VI")) {return true;}
        if (s.equals("VII")) {return true;}
        if (s.equals("VIII")) {return true;}
        if (s.equals("IX")) {return true;}
        if (s.equals("X")) {return true;}

        return false;
    }
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        System.out.println(line);
        String input_chars[] = line.split(" ");
        ArrayList<Integer> num_arabskiye = new ArrayList<>(10);
        num_arabskiye.add(1);


        HashMap<String, Integer> m = new HashMap<>();
        m.put("I",      1);
        m.put("II",     2);
        m.put("III",    3);
        m.put("IV",     4);
        m.put("V",      5);
        m.put("VI",     6);
        m.put("VII",    7);
        m.put("VIII",   8);
        m.put("IX",     9);
        m.put("X",      10);
        m.put("1",      1);
        m.put("2",      2);
        m.put("3",      3);
        m.put("4",      4);
        m.put("5",      5);
        m.put("6",      6);
        m.put("7",      7);
        m.put("8",      8);
        m.put("9",      9);
        m.put("10",     10);
        Integer result=0;
        switch (input_chars[1]){
            case "+":result = m.get(input_chars[0]) + m.get(input_chars[2]);
                break;
            case "-":result = m.get(input_chars[0]) - m.get(input_chars[2]);
                break;
            case "/":result = m.get(input_chars[0]) / m.get(input_chars[2]);
                break;
            case "*":result = m.get(input_chars[0]) * m.get(input_chars[2]);
                break;
        }
        //а теперь проверим и выведем вывод в соответствии с вводом. там должно было быть так:
        //если ввод арабский - вывод арабский, если ввод римский - вывод римский, если и то и то, то исключение.
        //а если ввод арабско-римский или римско-арабский, то увы, надо выдать исключение (хотя и нелогично).
        if (isArabic(input_chars[0]) && isArabic(input_chars[2])) {
            System.out.println(result);
        }
        if (isRimic(input_chars[0]) && isRimic(input_chars[2])) {
            System.out.println(arabToRome(result));
        }
        if (isArabic(input_chars[0]) == isRimic(input_chars[2])) {
            throw new IOException("Ошибка ввода разных типов данных");
        }

    }
}
