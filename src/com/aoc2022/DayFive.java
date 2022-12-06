package com.aoc2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFive extends AOCBase{
    public DayFive(String currentDay) {
        super(currentDay);
    }

    @Override
    void solvePartOne(List<String> input) {
        List<String> containers = new ArrayList<>();
        List<String> instructions = new ArrayList<>();

        List<Stack<Character>> containerState = new ArrayList<>();

        int i = 0;
        while (!input.get(i).equals("")) {
            containers.add(input.get(i));
            i++;
        }
        for (int j = i+1; j < input.size(); j++) {
            instructions.add(input.get(j));
        }

        String finalLine = containers.get(containers.size()-1);

        for (i = 0; i < finalLine.length(); i++) {
            if (finalLine.charAt(i) != ' ') {
                int whichStack = Character.getNumericValue(finalLine.charAt(i)) - 1;
                containerState.add(new Stack<>());

                for (int j = containers.size()-2; j >= 0; j--) {
                    if (containers.get(j).charAt(i) == ' ') {
                        break;
                    }
                    containerState.get(whichStack).push(containers.get(j).charAt(i));
                }

            }
        }
//        System.out.println(containerState);
        for (String line : instructions) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(line);
            List<Integer> values = new ArrayList<>();

            while(m.find()) {
                values.add(Integer.parseInt(m.group()));
            }

            int quantityToMove = values.get(0);
            int initialStackIndex = values.get(1)-1;
            int targetStackIndex = values.get(2)-1;

            for (i = 0; i < quantityToMove; i++) {
                char poppedVal = containerState.get(initialStackIndex).pop();
                containerState.get(targetStackIndex).push(poppedVal);
            }

        }

        for (Stack<Character> stack : containerState) {
            System.out.print(stack.peek());
        }
        System.out.println();

    }


    @Override
    void solvePartTwo(List<String> input) {
        List<String> containers = new ArrayList<>();
        List<String> instructions = new ArrayList<>();

        List<Stack<Character>> containerState = new ArrayList<>();

        int i = 0;
        while (!input.get(i).equals("")) {
            containers.add(input.get(i));
            i++;
        }
        for (int j = i+1; j < input.size(); j++) {
            instructions.add(input.get(j));
        }

        String finalLine = containers.get(containers.size()-1);

        for (i = 0; i < finalLine.length(); i++) {
            if (finalLine.charAt(i) != ' ') {
                int whichStack = Character.getNumericValue(finalLine.charAt(i)) - 1;
                containerState.add(new Stack<>());

                for (int j = containers.size()-2; j >= 0; j--) {
                    if (containers.get(j).charAt(i) == ' ') {
                        break;
                    }
                    containerState.get(whichStack).push(containers.get(j).charAt(i));
                }

            }
        }
//        System.out.println(containerState);
        for (String line : instructions) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(line);
            List<Integer> values = new ArrayList<>();

            while(m.find()) {
                values.add(Integer.parseInt(m.group()));
            }

            int quantityToMove = values.get(0);
            int initialStackIndex = values.get(1)-1;
            int targetStackIndex = values.get(2)-1;


            List<Character> proxyContainers = new ArrayList<>();
            for (i = 0; i < quantityToMove; i++) {

                char poppedVal = containerState.get(initialStackIndex).pop();
                proxyContainers.add(poppedVal);

            }
            for (int j = proxyContainers.size()-1; j >= 0; j--) {
                containerState.get(targetStackIndex).push(proxyContainers.get(j));
            }
        }

        for (Stack<Character> stack : containerState) {
            System.out.print(stack.peek());
        }
        System.out.println();

    }
}
