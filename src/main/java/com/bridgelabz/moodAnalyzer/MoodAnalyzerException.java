package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzerException extends Exception{

   public enum ExceptionType {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS
    }

   public ExceptionType exceptiontype;

   public MoodAnalyzerException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptiontype=exceptionType;
    }
}
