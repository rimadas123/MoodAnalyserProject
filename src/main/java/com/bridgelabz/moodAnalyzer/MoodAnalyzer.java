package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzer {

    String message, mood;

    public MoodAnalyzer(){}

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String createMoodAnalyzer() {
        try {
            if (message.contains("Happy")) {
                mood = "Happy";
            } else if (message.contains("Sad")) {
                mood = "Sad";
            }
            return mood;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
