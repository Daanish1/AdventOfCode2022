package com.aoc2022;

import com.common.usage.FileReadHelper;

import java.util.List;

public class DayTwo {


    public static int solveOne(List<String> input) {
        int score = 0;

        for (int i = 0; i < input.size()-1; i+=2) {
            int opponentMove = input.get(i).charAt(0) - 'A';
            int yourMove = input.get(i+1).charAt(0) - 'X';


            if (opponentMove == yourMove) {
                score += 3;

            }
            if ((opponentMove + 1) % 3 == yourMove){
                score += 6;
            }

            score += yourMove + 1;

        }

        return score;

    }

    public static int solveTwo(List<String> input) {
        int score = 0;

        for (int i = 0; i < input.size() - 1; i += 2) {
            int opponentMove = input.get(i).charAt(0) - 'A';
            int expectedOutcome = input.get(i + 1).charAt(0) - 'X';


            if (expectedOutcome == 0) {
                score += ((opponentMove + 2) % 3) + 1;
            } else if (expectedOutcome == 1) {
                score += 3 + opponentMove + 1;
            } else {
                score += 6 + ((opponentMove + 1) % 3) + 1;
            }


        }

        return score;
    }



    public static void main(String[] args) {
        List<String> input = FileReadHelper.fileToList("inputFiles/day2.txt", 2);
        System.out.println(solveOne(input));
        System.out.println(solveTwo(input));
    }


}
