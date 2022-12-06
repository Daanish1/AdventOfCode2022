package com.aoc2022;

import java.util.Arrays;
import java.util.List;

public class DayFour extends AOCBase {


    public DayFour(String currentDay, int valuesPerLine) {
        super(currentDay, valuesPerLine);
    }

    @Override
    void solvePartOne(List<String> input) {
        int contained = 0;

        for (int i = 0; i < input.size(); i++) {
            String[] splitted = input.get(i).split(",");

            int[] firstAssignment = Arrays.stream(splitted[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondAssignment = Arrays.stream(splitted[1].split("-")).mapToInt(Integer::parseInt).toArray();


            if (((firstAssignment[0] >= secondAssignment[0]) && (firstAssignment[1] <= secondAssignment[1])) ||
                ((secondAssignment[0] >= firstAssignment[0]) && (secondAssignment[1] <= firstAssignment[1]))) {
                contained++;
            }

        }

        System.out.println(contained);

    }

    @Override
    void solvePartTwo(List<String> input) {
        int overlaps = 0;

        for (int i = 0; i < input.size(); i++) {
            String[] splitted = input.get(i).split(",");

            int[] firstAssignment = Arrays.stream(splitted[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondAssignment = Arrays.stream(splitted[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if ((secondAssignment[0] >= firstAssignment[0]) && (firstAssignment[1] >= secondAssignment[1])) {
                overlaps++;
            } else if ((firstAssignment[0] >= secondAssignment[0]) && (secondAssignment[1] >= firstAssignment[1])){
                overlaps++;
            } else if ((secondAssignment[0] <= firstAssignment[1]) && (secondAssignment[1] >= firstAssignment[0])) {
                overlaps++;
            }


        }

        System.out.println(overlaps);

    }
}
