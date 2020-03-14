package com.bridgelabz.moodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    //Parametrized Constructor
    public static MoodAnalyzer createMoodAnalyser(String message) {
        try {
            Class cls = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer");
            Constructor con = cls.getConstructor(String.class);
            Object obj = con.newInstance(message);
            return (MoodAnalyzer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //To return class object and constructor parameter
    public static Constructor<?> getConstructor(String s, Class cls) throws MoodAnalyzerException {
        try {
            Class aClass = Class.forName(s);
            return aClass.getConstructor(cls);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, "no such class found");
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,"no such method found");
        }
    }

    //To check the class object and parameter with parameterized constructor passing improper constructor parameter
    public static Object getConstructorWithParameter(String message, Class<String> stringClass,String mood) throws MoodAnalyzerException {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
            Object obj = constructor.newInstance(mood);
            return (Constructor) obj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, "no such class found");
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, "no such method found");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String invokeMethod(MoodAnalyzer moodAnalyzer, String methodName) {
        try {
            Method method = moodAnalyzer.getClass().getMethod(methodName);
            return (String) method.invoke(moodAnalyzer);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}