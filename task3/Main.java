package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void print(String s1, String s2, String s3, String s4, String s5){
        //Получаю данные из файла и записываю их в коллекцию
        ArrayList<Float> arrayList1 = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        ArrayList<Float> arrayList3 = new ArrayList<>();
        ArrayList<Float> arrayList4 = new ArrayList<>();
        ArrayList<Float> arrayList5 = new ArrayList<>();
        File file = new File(s1);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList1.add(Float.valueOf(line));
            }

            file = new File(s2);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                arrayList2.add(Float.valueOf(line));
            }

            file = new File(s3);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                arrayList3.add(Float.valueOf(line));
            }

            file = new File(s4);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                arrayList4.add(Float.valueOf(line));
            }

            file = new File(s5);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                arrayList5.add(Float.valueOf(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        float max = arrayList1.get(0) + arrayList2.get(0)+ arrayList3.get(0) + arrayList4.get(0) + arrayList5.get(0);
        int k =1;
        for(int i=0; i<arrayList1.size(); i++){
            if (max < arrayList1.get(i) + arrayList2.get(i)+ arrayList3.get(i) + arrayList4.get(i) + arrayList5.get(i) ) {
                max = arrayList1.get(i) + arrayList2.get(i) + arrayList3.get(i) + arrayList4.get(i) + arrayList5.get(i);
                k = i+1;
            }
        }
        System.out.println(k);

    }

    public static void main(String[] args) {
       print(args[0], args[1], args[2], args[3], args[4]);
    }
}
