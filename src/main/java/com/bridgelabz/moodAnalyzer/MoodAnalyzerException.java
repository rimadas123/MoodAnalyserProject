package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzerException extends Exception{

   public enum ExceptionType {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_SUCH_FIELD
    }

   public ExceptionType exceptiontype;

   public MoodAnalyzerException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptiontype=exceptionType;
    }
}
