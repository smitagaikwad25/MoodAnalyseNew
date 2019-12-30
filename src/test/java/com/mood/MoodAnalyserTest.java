package com.mood;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.mood.MoodAnalyserException.ExceptionType.NO_SUCH_CLASS;

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
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void givenNullMood_ShoudReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(MoodAnalyserException.class);
            String message = moodAnalyser.analyser();

        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTER_NULL, e.type);
        }
    }

    @Test
    public void givenMood_WhenEmpty_ShouldReturnMoodAnalyserExccption() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            String message = moodAnalyser.analyser();

        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTER_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.mood.MoodAnalyser").getConstructor(String.class);
            Object myObj = constructor.newInstance("I am in Happy");
            MoodAnalyser moodAnalyser = (MoodAnalyser) myObj;
            String message = moodAnalyser.analyser();
            Assert.assertEquals("happy", message);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("i m happy");
        String message = moodAnalyser.analyser();
        Assert.assertEquals("happy", message);
    }

    @Test
    public void givenObjectWithProperMessage_shouldReturnTrue() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am happy");
        MoodAnalyser moodAnalyser1 = MoodAnalyserFactory.createMoodAnalyser("i am happy");
        Assert.assertEquals(true, moodAnalyser.equals(moodAnalyser1));
    }

    @Test
    public void givenClass_WhenNotProper_ShouldReturnMoodAnalyser() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.mood.MoodAnalyser111").getConstructor(Integer.class);

        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_MOTHOD, "Plz Enter valid method name");
            }
            catch (MoodAnalyserException a) {
                a.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "Plz Enter valid class name");
            } catch (MoodAnalyserException ex) {
                ex.getMessage();
            }
        }
    }

    @Test
    public void givenMethod_WhenNotProper_ShouldReturnMoodAnalyser() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.mood.MoodAnalyser").getConstructor(Integer.class);

        } catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_MOTHOD, "Plz Enter valid method name");
            }
            catch (MoodAnalyserException a) {
                a.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "Plz Enter valid class name");
            } catch (MoodAnalyserException ex) {
                ex.getMessage();
            }
        }
    }

    @Test
    public void givenConstrutor_WithPram_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor constructor = MoodAnalyserFactory.getConstructor(String.class);
        Object object = MoodAnalyserFactory.getObject(constructor, "i am happy");
        MoodAnalyser object1 = (MoodAnalyser) object;
        Assert.assertEquals(true,object1.equals(new MoodAnalyser("i am happy")));
    }

    @Test
    public void givenConstructor_withoutParam_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor constructor = MoodAnalyserFactory.getConstructor();
        Object object = MoodAnalyserFactory.getObject(constructor);
        MoodAnalyser object1 = (MoodAnalyser) object;
        Assert.assertEquals(true,object1.equals(new MoodAnalyser()));
    }
}








