package com.bridgelabz.MoodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyserMain createMoodAnalyser(String msg) throws MoodAnalysisException {
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

    public static Object invokeMethod(Object moodAnalyseObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyseObject.getClass().getMethod(methodName,String.class,String.class).invoke(moodAnalyseObject);

        } catch (NoSuchMethodException e) {
            throw  new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,
                    "Define proper method");
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "May be issue with data enter");
        }
    }

    public static void setFieldValue(Object myObj, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
                Field field = myObj.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(myObj, fieldValue);
        } catch (NoSuchFieldException e) {
            throw  new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD,
                    "Define proper field Name");
        }
        catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.FIELD_SETTING_ISSUE,
                    "May be issue with data enter");
        }
    }
}
