package com.sean.chien.colorquiz;

import android.graphics.Color;

import java.util.Random;

public class Question{
    private final int[] colors ={Color.BLACK,Color.GRAY,Color.BLUE,Color.RED,
                                 Color.GREEN,Color.CYAN,Color.MAGENTA,Color.YELLOW};

    private final String[] colorsStr = {"Black","Gray","Blue","Red","Green",
                                        "Cyam","Mageta","Yellow"};

    private int leftColor;
    private int rightColor;
    private String questionLabel;
    private  boolean isRightAnswer;

    public Question() {
        this.leftColor = leftColor;
        this.rightColor = rightColor;
        this.questionLabel = questionLabel;
    }

    public void generatQuestion(){

        // 1. pick random color for left button
        Random rand = new Random();
        int leftRand = rand.nextInt(colors.length);
        leftColor = colors[leftRand];

        // 2. pick random color for right button but cannot be the same as left btn
        int rightRand = rand.nextInt(colors.length);
        while (rightRand == leftRand){
            rightRand = rand.nextInt(colors.length);
        }
        rightColor = colors[rightRand];

        // 3. pick the answer (randomly)
        int[] choices = {leftRand,rightRand};
        int answerRand = rand.nextInt(choices.length);
        isRightAnswer = answerRand !=0;
        int choice = choices[answerRand];
        questionLabel = colorsStr[choice];


    }

    public boolean isRightAnswer(){
        return isRightAnswer;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public int getRightColor() {
        return rightColor;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }
}
