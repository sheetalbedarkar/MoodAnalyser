package com.bridgelabz.MoodAnalyserTest;

import com.bridgelabz.MoodAnalyser.MoodAnalyserFactory;
import com.bridgelabz.MoodAnalyser.MoodAnalyserMain;
import com.bridgelabz.MoodAnalyser.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
    @Test
    public void givenMessage_whenSad_ShowReturnSad() throws MoodAnalysisException {
        String mood = null;
        mood = moodAnalyser.analyseMood("This is SAD mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_whenHappy_ShowReturnHappy() throws MoodAnalysisException {
        String mood = null;
        mood = moodAnalyser.analyseMood("This is HAPPY mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNullWithCustomException_ShouldReturnMoodAnalyserException() {
        MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
        }catch (MoodAnalysisException e){
            Assert.assertEquals("Please Enter Proper Mood",e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenEmptyMood_ShouldReturnMoodAnalyserException() {
        MoodAnalyserMain moodAnalyser = new MoodAnalyserMain("");
        try {
            moodAnalyser.analyseMood();
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalysisException {
        MoodAnalyserMain MoodAnalyserMain = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
        Assert.assertEquals(new MoodAnalyserMain("I am in happy mood"), MoodAnalyserMain);
    }

    @Test
    public void givenClassName_whenNoSuchClass_ReturnMoodAnalyserException() {
        MoodAnalyserMain moodAnalyser = null;
        try {
            MoodAnalyserMain MoodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethod_whenNotProper_ReturnMoodAnalyserException() {
        MoodAnalyserMain moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void giveHAppyMessage_withReflection_shouldReturnHappy()
    {
        try {
            Object myObj = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
            Object moodChange = MoodAnalyserFactory.invokeMethod(myObj, "analyseMood");
            Assert.assertEquals("HAPPY", moodChange);
        } catch (MoodAnalysisException e) {
            e.getCause().getCause().printStackTrace();
        }

    }

    @Test
    public void givenMoodAnalyyser_OnChangeMood_ShouldReturnHappy()
    {
        try {
            Object myObj = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
            MoodAnalyserFactory.setFieldValue(myObj, "message", "I am in HAPPY mood");
            Object moodChange = MoodAnalyserFactory.invokeMethod(myObj, "analyseMood");
            Assert.assertEquals("HAPPY", moodChange);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

}
