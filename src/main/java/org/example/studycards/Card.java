package org.example.studycards;

import java.util.function.Supplier;

public class Card {

    private Supplier<String> questionSupplier;
    private Supplier<String> answerSupplier;

    public Card(String question, String answer) {
        this.questionSupplier = () -> question;
        this.answerSupplier = () -> answer;
    }

    public String getQuestion() {
        return questionSupplier.get();
    }

    public void setQuestion(String question) {
        this.questionSupplier = () -> question;
    }

    public String getAnswer() {
        return answerSupplier.get();
    }

    public void setAnswer(String answer) {
        this.answerSupplier = () -> answer;
    }

    public void edit(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }
}
