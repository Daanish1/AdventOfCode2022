package com.aoc2022;

import com.common.usage.FileReadHelper;

import java.io.File;
import java.util.List;

abstract public class AOCBase {

    public AOCBase(String currentDay, int valuesPerLine) {
        List<String> inputs = FileReadHelper.fileToList("inputFiles/day"+currentDay+".txt", valuesPerLine);

        System.out.println("==========Day "+ currentDay + "==========");
        System.out.print("Part One: ");
        solvePartOne(inputs);
        System.out.print("Part Two: ");
        solvePartTwo(inputs);

    }

    abstract void solvePartOne(List<String> input);
    abstract void solvePartTwo(List<String> input);

}
