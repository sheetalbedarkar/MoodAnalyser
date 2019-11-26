package com.bridgelabz.MoodAnalyserTest;

import com.bridgelabz.MoodAnalyser.MoodAnalyserMain;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_whenSad_ShowReturnSad() {
        MoodAnalyserMain moodAnalyser = new MoodAnalyserMain();
        String mood = moodAnalyser.analyseMood("SAD");
        Assert.assertEquals("SAD",mood);
    }
}
