package hyperquiz.model;

import java.io.Serializable;
import java.net.URL;

public class Answer implements Serializable {
    private Question question;
    private String text;
    private URL picture;
    private int score;

    public Answer() {
    }

    public Answer(Question question, String text, int score) {
        this.question = question;
        this.text = text;
        this.score = score;
    }

    public Answer(Question question, String text, URL picture, int score) {
        this.question = question;
        this.text = text;
        this.picture = picture;
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Answer{");
        sb.append("question=").append(question);
        sb.append(", text='").append(text).append('\'');
        sb.append(", picture=").append(picture);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
