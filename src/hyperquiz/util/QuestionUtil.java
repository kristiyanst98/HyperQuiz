package hyperquiz.util;

import hyperquiz.model.Answer;
import hyperquiz.model.Question;
import hyperquiz.model.Quiz;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class QuestionUtil {

    public static Question createQuestion(Quiz quiz){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=NOW CREATING QUESTION FOR QUIZ: "+quiz.getTitle());
        Question question = new Question();
        question.setQuiz(quiz);
        System.out.println("Enter question:");
        String text = scanner.nextLine();
        question.setText(text);
        question.getAnswers().add(AnswerUtil.createAnswer(question));
        return question;
    }
}
