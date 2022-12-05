package com.aoc2022;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree extends AOCBase{

    public DayThree(String currentDay, int valuesPerLine) {
        super(currentDay, valuesPerLine);
    }

    @Override
    void solvePartOne(List<String> input) {
        int prioritySum = 0;


        for (int i = 0; i < input.size(); i++) {
            String fullRucksack = input.get(i);

            List<Character> compartmentOne = input.get(i).substring(0, input.get(i).length()/2).chars().mapToObj((j)
                    -> Character.valueOf((char)j)).collect(Collectors.toList());

            List<Character> compartmentTwo = input.get(i).substring(input.get(i).length()/2).chars().mapToObj((j)
                    -> Character.valueOf((char)j)).collect(Collectors.toList());


            for (int j = 0; j < fullRucksack.length()/2; j++) {
                compartmentOne.add(fullRucksack.charAt(j));
            }
            for (int j = fullRucksack.length()/2; j < fullRucksack.length(); j++) {
                compartmentTwo.add(fullRucksack.charAt(j));
            }

            compartmentOne.retainAll(compartmentTwo);

            char mismatched = compartmentOne.get(0);

            if (mismatched <= 'Z') {
                prioritySum += mismatched - 38;
            } else {
                prioritySum += mismatched - 'a' + 1;
            }

        }

        System.out.println(prioritySum);

    }

    @Override
    void solvePartTwo(List<String> input) {
        int prioritySum = 0;

        for (int i = 0; i < input.size()-2; i+=3) {

            List<Character> firstRucksack = input.get(i).chars().mapToObj((j) -> Character.valueOf((char)j)).collect(Collectors.toList());
            List<Character> secondRucksack = input.get(i+1).chars().mapToObj((j) -> Character.valueOf((char)j)).collect(Collectors.toList());
            List<Character> thirdRucksack = input.get(i+2).chars().mapToObj((j) -> Character.valueOf((char)j)).collect(Collectors.toList());

            firstRucksack.retainAll(secondRucksack);
            firstRucksack.retainAll(thirdRucksack);

            char tag = firstRucksack.get(0);

            if (tag <= 'Z') {

                prioritySum += tag - 38;
            } else {
                prioritySum += tag - 'a' + 1;
            }

        }

        System.out.println(prioritySum);
    }
}
