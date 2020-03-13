package com.bridgelabz.moodAnalyzer;

import java.util.EmptyStackException;
import java.util.Objects;

public class MoodAnalyzer {

    private String message;
    String mood;

    public MoodAnalyzer(){}

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String MoodAnalyzer(String message) throws MoodAnalyzerException {
        this.message = message;
        return message;
    }

    public String createMoodAnalyzer() throws MoodAnalyzerException {
        try {
            if (message.length() == 0){
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(mood, that.mood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, mood);
    }
}
