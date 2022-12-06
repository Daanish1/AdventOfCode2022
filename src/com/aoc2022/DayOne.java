package com.aoc2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayOne extends AOCBase{

    public DayOne(String day, int numberOfValues) {
        super(day, numberOfValues);
    }

    @Override
    public void solvePartOne(List<String> input) {
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
            System.out.println(maxVal);
        else
            System.out.println(currentCount);
    }


    @Override
    public void solvePartTwo(List<String> input) {
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

        System.out.println(sum);


    }

}
