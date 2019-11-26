package com.bridgelabz.MoodAnalyserTest;

import com.bridgelabz.MoodAnalyser.MoodAnalyserMain;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyserMain moodAnalyser = new MoodAnalyserMain(null);
    @Test
    public void givenMessage_whenSad_ShowReturnSad() {
        String mood = moodAnalyser.analyseMood("This is SAD mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_whenHappy_ShowReturnHappy() {
        String mood = moodAnalyser.analyseMood("This is HAPPY mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
