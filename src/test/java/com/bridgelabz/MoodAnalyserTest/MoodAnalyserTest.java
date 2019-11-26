package com.bridgelabz.MoodAnalyserTest;

import com.bridgelabz.MoodAnalyser.MoodAnalyserMain;
import com.bridgelabz.MoodAnalyser.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
    @Test
    public void givenMessage_whenSad_ShowReturnSad() {
        String mood = null;
        mood = moodAnalyser.analyseMood("This is SAD mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_whenHappy_ShowReturnHappy() {
        String mood = null;
        mood = moodAnalyser.analyseMood("This is HAPPY mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() {
        MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
