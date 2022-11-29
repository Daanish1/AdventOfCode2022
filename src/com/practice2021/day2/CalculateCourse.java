package com.practice2021.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculateCourse {


    public static int solveSecond(String path) {

        int depth = 0;
        int horiz = 0;
        int aim = 0;

        BufferedReader objReader;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(path));

            while ((strCurrentLine = objReader.readLine()) != null) {

                String[] splitted = strCurrentLine.split(" ");

                int val = Integer.parseInt(splitted[1]);

                if (splitted[0].equals("forward")) {
                    horiz += val;
                    depth += aim * val;
                } else if (splitted[0].equals("up")) {
                    aim -= val;
                } else {
                    aim += val;
                }
            }



        } catch (IOException e) {
            System.out.println("Error");
        }

        return depth*horiz;

    }
//    public static int solve(String path) {
//
//        int depth = 0;
//        int horiz = 0;
//
//        BufferedReader objReader;
//        try {
//            String strCurrentLine;
//
//            objReader = new BufferedReader(new FileReader(path));
//
//            while ((strCurrentLine = objReader.readLine()) != null) {
//
//                String[] splitted = strCurrentLine.split(" ");
//
//                int val = Integer.parseInt(splitted[1]);
//
//                if (splitted[0].equals("forward")) {
//                    horiz += val;
//                } else if (splitted[0].equals("up")) {
//                    depth -= val;
//                } else {
//                    depth += val;
//                }
//            }
//
//
//
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
//
//        return depth*horiz;
//
//    }


    public static void main(String[] args) {
        System.out.println(solveSecond("inputFiles/input_2.txt"));
    }
}
