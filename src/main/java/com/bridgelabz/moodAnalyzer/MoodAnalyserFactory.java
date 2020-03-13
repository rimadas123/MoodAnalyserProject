package com.bridgelabz.moodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    // Default constructor
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor();
            Object obj = constructor.newInstance();
            return (MoodAnalyzer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // To check improper class name
    public static MoodAnalyzer getConstructor(String s, Class cls) throws MoodAnalyzerException {
            try {
                Constructor constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
            }
        return null;
    }
}