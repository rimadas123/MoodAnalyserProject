package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzer {

    String message, mood;

    public MoodAnalyzer(){}

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String MoodAnalyzer(String message) throws MoodAnalyzerException {
        this.message=message;
        return MoodAnalyzer(null);
    }

    public String createMoodAnalyzer() throws MoodAnalyzerException{
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
}
