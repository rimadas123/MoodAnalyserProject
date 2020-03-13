package com.bridgelabz.moodAnalyzer;

import java.util.EmptyStackException;

public class MoodAnalyzer {

    String message, mood;

    public MoodAnalyzer(){}

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String createMoodAnalyzer() throws MoodAnalyzerException{
        try {
            if (message.length() == 0){
                mood="";
            }
            if (message.contains("Happy")) {
                mood = "Happy";
            } else if (message.contains("Sad")) {
                mood = "Sad";
            }
            return mood;
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_NULL,"Please enter proper mood");
        }
    }
}
