package com.bridgelabz.MoodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyserMain createMoodAnalyser() throws MoodAnalysisException {
        try {
            Class<?> MoodAnalyserMainClass = Class.forName("com.bridgelabz.MoodAnalyser.MoodAnalyserMain");
            Constructor<?> moodConstructor = MoodAnalyserMainClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyserMain) moodObject;
        }catch (ClassNotFoundException e) {
            throw new  MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"please Enter Proper Class Name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new  MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"please Enter Proper Method Name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
