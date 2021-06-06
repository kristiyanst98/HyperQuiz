package hyperquiz.model;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private Quiz quiz;
    private String text;
    private URL picture;
    private List<Answer> answers;

    public Question() {
        this.answers=new ArrayList<>();
    }

    public Question(Quiz quiz, String text) {
        this.quiz = quiz;
        this.text = text;
        this.answers=new ArrayList<>();
    }

    public Question(Quiz quiz, String text, URL picture) {
        this.quiz = quiz;
        this.text = text;
        this.picture = picture;
        this.answers=new ArrayList<>();
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Question{");
        sb.append("quiz=").append(quiz);
        sb.append(", text='").append(text).append('\'');
        sb.append(", picture=").append(picture);
        sb.append(", answers=").append(answers);
        sb.append('}');
        return sb.toString();
    }
}
