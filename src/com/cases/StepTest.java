package com.cases;

public class StepTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(getStepCount(13));
    }

    private static int getStepCount(int count) {
        if (count < 2) {
            return Math.max(0, count);
        }
        int stepOne = 1;
        int stepTwo = 2;
        int step = 3;
        while(step < count) {
            int tmp = stepOne + stepTwo;
            stepOne = stepTwo;
            stepTwo = tmp;
            step ++;
        }
        return stepOne + stepTwo;
    }
}
