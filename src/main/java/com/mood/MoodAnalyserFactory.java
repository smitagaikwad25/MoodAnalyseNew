package com.mood;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {


    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.mood.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor getConstructor(Class<?>... parameter) {
        try {
            Class<?> aClass = Class.forName("com.mood.MoodAnalyser");
            Constructor<?> constructor = aClass.getConstructor(parameter);

            return constructor;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object getObject(Constructor constructor, String... message) {
        Object moodObj = null;
        try {
            moodObj = constructor.newInstance(message);
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return moodObj;
    }
}
