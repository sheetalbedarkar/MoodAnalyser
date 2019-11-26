package com.bridgelabz.MoodAnalyser;

public class MoodAnalyserMain {
    String message;

    public MoodAnalyserMain() {
    }

    public MoodAnalyserMain(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if(message.length() == 0)
                throw new  MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please Enter Proper Mood");
            if(message.contains("SAD")) {
                return "SAD";
            }
            else {
                return "HAPPY";
            }
        } catch (MoodAnalysisException e) {
            throw new  MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please Enter Proper Mood");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MoodAnalyserMain)
            return true;
        return false;
    }
}
