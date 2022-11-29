package com.practice2021.day3;

import com.common.usage.FileReadHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerConsumption {

    public static int calculatePowerConsumption(List<String> inputs) {
        int[] counts = new int[inputs.get(0).length()];



        for (int i = 0; i < inputs.size(); i++) {

            String currentInput = inputs.get(i);

            for (int j = 0; j < currentInput.length(); j++) {

                if (currentInput.charAt(j) == '1') {
                    counts[j] = counts[j] + 1;
                } else {
                    counts[j] = counts[j] - 1;
                }
            }

        }

        int multiplier = inputs.get(0).length() - 1;
        int gammaRate = 0;
        int epsilonRate = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                gammaRate += Math.pow(2, multiplier);

            } else {
                epsilonRate += Math.pow(2, multiplier);
            }

            multiplier--;
        }

        return gammaRate*epsilonRate;

    }

    public static List<String> removeVals(List<String> in, char valToRemove, int atIndex) {
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i).charAt(atIndex) == valToRemove) {
                in.remove(i);
                i--;
            }
        }
        return in;
    }


    public static int calculateLifeSupport(List<String> inputs) {

        List<String> secondInputs = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            secondInputs.add(inputs.get(i));
        }

        int bitLength = inputs.get(0).length();




        String oxygen;
        String scrubber;

        for (int i = 0; i < bitLength; i++) {

            int tempIndex = i;

            if (inputs.size() == 1) {
                break;
            }

            long oneCount = inputs.stream().mapToInt(bit -> Integer.parseInt(Character.toString(bit.charAt(tempIndex)))).filter(n -> n == 1).count();
            long zeroCount = inputs.stream().mapToInt(bit -> Integer.parseInt(Character.toString(bit.charAt(tempIndex)))).filter(n -> n == 0).count();

            if ((oneCount == 0) || (zeroCount == 0))
                break;


            char valToRemove;

            if (oneCount >= zeroCount) {
                valToRemove = '0';
            } else {
                valToRemove = '1';
            }

            for (int j = 0; j < inputs.size(); j++) {
                if (inputs.get(j).charAt(i) == valToRemove) {
                    inputs.remove(j);
                    j--;
                }
            }



        }

        oxygen = inputs.get(0);




        for (int i = 0; i < bitLength; i++) {

            int tempIndex = i;

            if (secondInputs.size() == 1) {
                break;
            }

            long oneCount = secondInputs.stream().mapToInt(bit -> Integer.parseInt(Character.toString(bit.charAt(tempIndex)))).filter(n -> n == 1).count();
            long zeroCount = secondInputs.stream().mapToInt(bit -> Integer.parseInt(Character.toString(bit.charAt(tempIndex)))).filter(n -> n == 0).count();

            if ((oneCount == 0) || (zeroCount == 0))
                break;


            char valToRemove;

            if (oneCount >= zeroCount) {
                valToRemove = '1';
            } else {
                valToRemove = '0';
            }

            for (int j = 0; j < secondInputs.size(); j++) {
                if (secondInputs.get(j).charAt(i) == valToRemove) {
                    secondInputs.remove(j);
                    j--;
                }
            }



        }

        scrubber = secondInputs.get(0);

        int oxygenInt = 0;
        int scrubberInt = 0;

        int multiplier = oxygen.length() - 1;

        for (int i = 0; i < oxygen.length(); i++) {
            if (oxygen.charAt(i) == '1') {
                oxygenInt += Math.pow(2, multiplier);
            }

            if (scrubber.charAt(i) == '1') {
                scrubberInt += Math.pow(2, multiplier);
            }

            multiplier--;
        }



        return oxygenInt*scrubberInt;


    }

    public static void main(String[] args) {
        List<String> inputs = FileReadHelper.fileToList("inputFiles/input_3.txt", 1);
        System.out.println(calculatePowerConsumption(inputs));

        System.out.println(calculateLifeSupport(inputs));



    }
}
