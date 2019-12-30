package com.mood;

public class MoodAnalyserException extends RuntimeException{
   public enum ExceptionType {
        ENTER_NULL,ENTER_EMPTY,NO_SUCH_CLASS,NO_SUCH_MOTHOD;
    }

   public ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
       this.type = type;
    }
}
