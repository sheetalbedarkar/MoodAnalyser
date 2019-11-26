package com.bridgelabz.MoodAnalyserTest;

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
            Assert.assertEquals("Please Enter proper Mood",e.getMessage());
        }
    }


}
