package com.practice2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadHelper {

    public static List<String> fileToList(String inputPath, int valuesPerLine) {

        List<String> inputs = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputPath));
            String strCurrentLine;
            while((strCurrentLine = reader.readLine()) != null) {
                String[] splitted = strCurrentLine.split(" ");

                for (int i = 0; i < valuesPerLine; i++) {
                    inputs.add(splitted[i]);
                }
            }

            return inputs;

        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }

    }

//    public static void main(String[] args) {
//
//        List<String> x = fileToList("inputFiles/input_2.txt", 2);
//        for (int i = 0; i < x.size(); i++) {
//            System.out.println(x.get(i));
//        }
//    }

}
