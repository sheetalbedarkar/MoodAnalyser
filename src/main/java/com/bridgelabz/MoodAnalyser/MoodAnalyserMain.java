package com.bridgelabz.MoodAnalyser;

public class MoodAnalyserMain {
    String message;

    public MoodAnalyserMain() {
    }

    public MoodAnalyserMain(String message) {
        this.message = message;
    }

    public String analyseMood(String message){
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() {
        try {
            if(message.contains("SAD")) {
                return "SAD";
            }
            else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}
