package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Main {
    public static void print(String s1) throws IOException {
        //Получаю данные из файла и записываю их в коллекцию
        ArrayList<Time> arrayList = new ArrayList<>();

        File file = new File(s1);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line ;
            while ((line = reader.readLine()) != null) {
                String s[] = line.trim().split(" ");
                String string1 = s[0].replace(":", "");
                String string2 = s[1].replace(":", "");
                Time time1 = new Time(Integer.valueOf(string1), s[0], 1);
                Time time2 = new Time(Integer.valueOf(string2), s[1], -1);
                arrayList.add(time1);
                arrayList.add(time2);
            }
            sort(arrayList);//сортировка
            perebor(arrayList);//складывает показатели с одинаковым временем
            int max=0;
            int i=0;
            for (Time t: arrayList){ //присваиваем каждому моменту времени количество людей находившихся в банке
                i += t.k;
                if (max<i)
                    max=i;
                t.c = i;
            }

        int m=0;
        while (m<arrayList.size()){
            if (arrayList.get(m).c==max){
                System.out.print(arrayList.get(m).time+"  ");
                while (arrayList.get(m).c == max)
                    m++;
                System.out.println(arrayList.get(m).time);
            }
            m++;
        }


    }
    public static void main(String[] args) throws IOException {
        print(args[0]);
    }

    public static void sort(ArrayList<Time> arr){
        for (int i=0; i<arr.size(); i++){

            int min = arr.get(i).t;
            int minId = i;
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j).t < min) {
                    min = arr.get(j).t;
                    minId = j;
                }
            }
                int tmp = arr.get(i).t;
                arr.get(i).t = min;
                arr.get(minId).t = tmp;
                String s =  arr.get(i).time;
                arr.get(i).time = arr.get(minId).time;
                arr.get(minId).time = s;
                tmp = arr.get(i).k;
                arr.get(i).k = arr.get(minId).k;
                arr.get(minId).k = tmp;
        }
    }

    public static void perebor(ArrayList<Time> arr){
        int j = 0;
        int i = 1;
        while (i<arr.size()){
          if (arr.get(i).t.equals(arr.get(j).t)){
              arr.get(i).k+=arr.get(j).k;
              arr.remove(arr.get(j));

          }else {
              i++;
              j++;
          }

        }
    }


    private static class Time {
        Integer t;
        String time;
        int k; //1 пришел -1 ушел
        int c;

        public Time(Integer t, String time, int k) {
            this.t = t;
            this.time = time;
            this.k = k;
        }
    }
}