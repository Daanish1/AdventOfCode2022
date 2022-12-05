package com.aoc2022;

import com.common.usage.FileReadHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayOne {

    public static int partOne(List<String> input) {
        int maxVal = 0;

        int currentCount = 0;
        for (int i = 0; i < input.size(); i++) {

            if (input.get(i).equals("")) {
                if (currentCount > maxVal) {
                    maxVal = currentCount;
                }
                currentCount = 0;
            } else {
                currentCount += Integer.parseInt(input.get(i));
            }
        }

        if (maxVal > currentCount)
            return maxVal;
        else
            return currentCount;
    }

    public static int partTwo(List<String> input) {
        List<Integer> calorieCount = new ArrayList<>();


        int currentCount = 0;
        for (int i = 0; i < input.size(); i++) {

            if (input.get(i).equals("")) {
                calorieCount.add(currentCount);
                currentCount = 0;
            } else {
                currentCount += Integer.parseInt(input.get(i));
            }
        }

        calorieCount.add(currentCount);

        Collections.sort(calorieCount);

        int lastIndex = calorieCount.size()-1;
        int sum = calorieCount.get(lastIndex) + calorieCount.get(lastIndex-1) + calorieCount.get(lastIndex-2);

        return sum;


    }




    public static void main(String[] args) {
        List<String> input = FileReadHelper.fileToList("inputFiles/day1.txt", 1);
        System.out.println(partOne(input));
        System.out.println(partTwo(input));

        
    }


}
