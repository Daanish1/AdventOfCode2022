package com.aoc2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract public class AOCBase {


    public AOCBase(String currentDay) {
        List<String> inputs = readFile("inputFiles/day"+currentDay+".txt");
        computeOutput(currentDay, inputs);
    }

    public AOCBase(String currentDay, int valuesPerLine) {
        List<String> inputs = fileToListWithValues("inputFiles/day"+currentDay+".txt", valuesPerLine);

        computeOutput(currentDay, inputs);

    }

    public void computeOutput(String currentDay, List<String> inputs) {
        System.out.println("==========Day "+ currentDay + "==========");
        System.out.print("Part One: ");
        solvePartOne(inputs);
        System.out.print("Part Two: ");
        solvePartTwo(inputs);
    }

    public List<String> fileToListWithValues(String inputPath, int valuesPerLine) {

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

    public List<String> readFile(String inputPath) {
        List<String> inputs = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputPath));
            String strCurrentLine;
            while((strCurrentLine = reader.readLine()) != null) {

                inputs.add(strCurrentLine);

            }

            return inputs;

        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    abstract void solvePartOne(List<String> input);
    abstract void solvePartTwo(List<String> input);

}
