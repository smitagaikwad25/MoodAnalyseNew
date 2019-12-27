package com.mood;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Test
    public void givenMood_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        String message = moodAnalyser.analyser();
        Assert.assertEquals("Sad", message);
    }
    @Test
    public void givenHappyMsg_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i m happy");
        String message = moodAnalyser.analyser();
        Assert.assertEquals("happy", message);
    }
    @Test
    public void whenGivenSadMsgWithSAlphabetCapital_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i m Sad");
        String message = moodAnalyser.analyser();
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void givenNullMood_ShoudReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(MoodAnalyserException.class);
           String message = moodAnalyser.analyser();

        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTER_NULL,e.type);
        }
    }

    @Test
    public void givenMood_WhenEmpty_ShouldReturnMoodAnalyserExccption() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            String message = moodAnalyser.analyser();

        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTER_EMPTY,e.type);
        }
    }


}
