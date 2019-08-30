package com.example.quizz;


public class Question {
    private int Questionid;
    private boolean answer;

    public Question(int questionid, boolean answer) {
        Questionid = questionid;
        this.answer = answer;
    }

    public int getQuestionid() {
        return Questionid;
    }

    public void setQuestionid(int questionid) {
        Questionid = questionid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}