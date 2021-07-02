package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void print(String s){
        //Получаю данные из файла и записываю их в коллекцию
        ArrayList<Short> arrayList = new ArrayList<>();
        File file = new File(s);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                 arrayList.add(Short.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //сортирую коллекцию
        Collections.sort(arrayList);
        int n = arrayList.size();
        int percentile = (int) (90/ 100.0 * n);

        // 90 перцентиль
        // не очень понял как правильно находить этот парамеир
        System.out.printf("%.2f%n" , (double) arrayList.get(percentile-1) );

        //медиана
        if(arrayList.size() % 2 == 0)
            System.out.printf("%.2f%n" , (double) (arrayList.get(n/2) + arrayList.get(n/2-1)) / 2);
        else
            System.out.printf("%.2f%n" , (double) (arrayList.get(n/2)));
        //максимальное и минимальное значения
        System.out.printf("%.2f%n", (double) arrayList.get(n-1));
        System.out.printf("%.2f%n", (double) arrayList.get(0));
        //среднее
        short sum=0;
        for(Short sh : arrayList) {
            sum += sh;
        }
        System.out.printf("%.2f%n", (double)sum/n);
    }

    public static void main(String[] args) {
      print(args[0]);

    }

}
