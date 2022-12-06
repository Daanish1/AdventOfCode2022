package com.aoc2022;

import java.util.List;
import java.util.stream.IntStream;


public class DaySix extends AOCBase{

    public DaySix(String currentDay) {
        super(currentDay);
    }

    @Override
    void solvePartOne(List<String> input) {
        String dataStream = input.get(0);
        int length = 4;

        for (int i = 0; i < dataStream.length(); i++) {
            if (dataStream.substring(i, i+length).chars().distinct().count() == length) {
                System.out.println(i + length);
                break;
            }
        }



    }


    @Override
    void solvePartTwo(List<String> input) {
        String dataStream = input.get(0);
        int length = 14;

        for (int i = 0; i < dataStream.length(); i++) {
            if (dataStream.substring(i, i+length).chars().distinct().count() == length) {
                System.out.println(i + length);
                break;
            }
        }
    }
}
