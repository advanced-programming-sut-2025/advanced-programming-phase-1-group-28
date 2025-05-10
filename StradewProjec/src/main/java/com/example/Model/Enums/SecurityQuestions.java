package com.example.Model.Enums;

public enum SecurityQuestions {
    question1("What is your favorite color"),
    question2("What is your favorite Animal"),
    question3("Does Someone Raped you in child"),
    question4("Are you Dumb(Study EE))");
    public final String QuestionName;

    SecurityQuestions(String questionName) {
        QuestionName = questionName;
    }
}
