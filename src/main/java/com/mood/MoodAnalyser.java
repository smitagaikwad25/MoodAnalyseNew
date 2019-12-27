package com.mood;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser(){

    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyser() {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTER_EMPTY,"Plz Enter valid Mood");
            if (message.contains("sad") || message.contains("Sad"))
                return "Sad";
            else
                return "happy";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTER_NULL,"Plz Enter valid Mood");
        }
    }
}