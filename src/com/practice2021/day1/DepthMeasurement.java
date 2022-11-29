package com.practice2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepthMeasurement {


    public static List<Integer> readInput(String path) {

        ArrayList<Integer> inputs = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputs.add(Integer.parseInt(data));
            }

        } catch (FileNotFoundException e) {
            return null;
        }

        return inputs;
    }

    public static int howManyLarger(List<Integer> in) {

        int count = 0;
        int previous = in.get(0);
        for (int i = 1; i < in.size(); i++) {
            if (in.get(i) > previous) {
                count++;
            }

            previous = in.get(i);
        }

        return count;

    }

    public static int howManyLargerThrees(List<Integer> in) {
        int count = 0;

        for (int i = 0; i < in.size()-3; i++) {
            int currentSum = in.get(i) + in.get(i+1) + in.get(i+2);
            int secondSum = currentSum + in.get(i+3) - in.get(i);

            if (secondSum > currentSum) {
                count++;
            }

        }
        return count;
    }



    public static void main(String[] args) {
        List<Integer> in = readInput("inputFiles/input_1.txt");
        System.out.println(in);
        System.out.println(howManyLarger(in));

        System.out.println(howManyLargerThrees(in));
    }


}
