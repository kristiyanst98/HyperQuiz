package hyperquiz.util;

import hyperquiz.model.Question;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class QuizUtil {

    public static Quiz createQuiz(){
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        System.out.println("----CREATING QUIZ----");
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        quiz.setTitle(title);
        System.out.println("Enter description:");
        String desc = scanner.nextLine();
        quiz.setDescription(desc);
        System.out.println("Enter expected duration:");
        int expected = scanner.nextInt();
        scanner.nextLine();
        quiz.setExpectedDuration(expected);
        System.out.println("Enter tags:");
        String tags = scanner.nextLine();
        quiz.setTags(tags);
        System.out.println("Enter number of questions:");
        int questions = scanner.nextInt();
        scanner.nextLine();
        for(int i =0;i<questions;i++){
            quiz.getQuestions().add(QuestionUtil.createQuestion(quiz));
        }

        return quiz;
    }
}
