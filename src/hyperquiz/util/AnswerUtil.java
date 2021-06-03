package hyperquiz.util;

import hyperquiz.model.Answer;
import hyperquiz.model.Question;

import java.net.URL;
import java.util.Scanner;

public class AnswerUtil {

    public static Answer createAnswer(Question question){
        Scanner scanner = new Scanner(System.in);
        Answer answer = new Answer();
        answer.setQuestion(question);
        System.out.println("Enter answer text:");
        String text = scanner.nextLine();
        answer.setText(text);
        System.out.println("Enter score:");
        int score = scanner.nextInt();
        answer.setScore(score);
        return answer;

    }
}
