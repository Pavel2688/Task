package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //находит положение точки но только относительно прямоугольника
    public static void print(String s1, String s2){
        //Получаю данные из файла и записываю их в коллекцию
        ArrayList<Float> arrayList1 = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        File file = new File(s1);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line ;
            while ((line = reader.readLine()) != null) {
                String s[] = line.trim().split(" ");
                arrayList1.add(Float.valueOf(s[0]));
                arrayList1.add(Float.valueOf(s[1]));
            }
            file = new File(s2);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String s[] = line.trim().split(" ");
                arrayList2.add(Float.valueOf(s[0]));
                arrayList2.add(Float.valueOf(s[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        float x1=arrayList1.get(0);
        float y1=arrayList1.get(1);
        float x2=arrayList1.get(2);
        float y2=arrayList1.get(3);
        float x3=arrayList1.get(4);
        float y3=arrayList1.get(5);
        float x4=arrayList1.get(6);
        float y4=arrayList1.get(7);
        for(int i=0; i< arrayList2.size(); i+=2) {
            float a = arrayList2.get(i);
            float b = arrayList2.get(i+1);
            if ( (a==x1 && b==y1) || (a==x2 && b==y2) || (a==x3 && b==y3) || (a==x4 && b==y4)) {
                System.out.println(0);
            }else  {
                if ( ((a==x1 || a==x3) && !((b>y1) && (b>y3)) && !((b<y1) && (b<y3))) ||
                        ((b==y1 || b==y3) && !((a>x1) && (a>x3) )  && !((a<x1) && (a<x3) )  )){
                    System.out.println(1);
                }else {
                  if ( (a>x1 && a>x2 && a>x3 && a>x4) || (a<x1 && a<x2 && a<x3 && a<x4)
                     || (b>y1 && b>y2 && b>y3 && b>y4) || (b<y1 && b<y2 && b<y3 && b<y4) ){
                      System.out.println(3);
                  }else
                      System.out.println(2);
                }
            }

        }
    }

    public static void main(String[] args) {
        print(args[0], args[1]);

    }
}
