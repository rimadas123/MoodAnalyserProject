package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzerException extends Exception{

   public enum ExceptionType {
        ENTERED_NULL,ENTERED_EMPTY
    }

   public ExceptionType exceptiontype;

   public MoodAnalyzerException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptiontype=exceptionType;
    }
}
