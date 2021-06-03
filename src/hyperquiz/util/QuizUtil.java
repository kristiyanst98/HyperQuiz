package hyperquiz.util;

import hyperquiz.model.Question;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class QuizUtil {

    public static Quiz createQuiz() {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        System.out.println("----CREATING QUIZ----");
        do {
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            if (ValidationUtil.validateString(title, 2, 80)) {
                quiz.setTitle(title);
                break;
            } else {
                System.out.println("Title must be between 2 and 80 characters");
            }
        } while (true);
        do {
            System.out.println("Enter description:");
            String desc = scanner.nextLine();
            if (ValidationUtil.validateString(desc, 20, 250)) {
                quiz.setDescription(desc);
                break;
            } else {
                System.out.println("Description must be between 20 and 250 characters");
            }
        } while (true);
        do {
            System.out.println("Enter expected duration:");
            int expected = scanner.nextInt();
            scanner.nextLine();
            if (ValidationUtil.validateNumber(expected)) {
                quiz.setExpectedDuration(expected);
                break;
            } else {
                System.out.println("Enter a positive number");
            }
        } while (true);
        do {
            System.out.println("Enter tags:");
            String tags = scanner.nextLine();
            if (ValidationUtil.validateTags(tags)) {
                quiz.setTags(tags);
                break;
            } else {
                System.out.println("Enter a valid tag");
            }
        } while (true);
        do {
            System.out.println("Enter number of questions:");
            int questions = scanner.nextInt();
            scanner.nextLine();
            if (ValidationUtil.validateNumber(questions)) {
                for (int i = 0; i < questions; i++) {
                    quiz.getQuestions().add(QuestionUtil.createQuestion(quiz));
                }
                break;
            }else{
                System.out.println("Enter a positive number");
            }
        } while (true);
        return quiz;
    }
}
