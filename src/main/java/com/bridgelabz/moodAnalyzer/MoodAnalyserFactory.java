package com.bridgelabz.moodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    // Default constructor
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
            Object obj = constructor.newInstance();
            return (MoodAnalyzer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}