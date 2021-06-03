package hyperquiz.util;

import hyperquiz.dao.QuizRepository;
import hyperquiz.exceptions.EntityAlreadyExistsException;

import java.util.Scanner;

public class MenuUtil {
    public static void printMenu(QuizRepository qr) throws EntityAlreadyExistsException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Select an option:\n"+
                    "<0> Exit\n" +
                    "<1> Create Quiz\n" +
                    "<2> Create User\n"+
                    "<3> Print Quizzes\n"+
                    "<4> Print Users");
            int num = scanner.nextInt();
            switch(num){
                case 0:
                    System.out.println("Quitting...");
                    return;
                case 1:
                    qr.create(QuizUtil.createQuiz());
                    break;
                case 2:
//                    UserUtil.createUser();
                    break;
                case 3:

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
