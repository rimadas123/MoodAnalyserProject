package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzer {

    String message, mood = "Happy";

    public MoodAnalyzer(){}

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String createMoodAnalyzer() {
        if (message.contains("Happy")) {
            mood = "Happy";
            return mood;
        }
        else if (message.contains("Sad")) {
            mood = "Sad";
            return mood;
        }
        return mood;
    }
}
