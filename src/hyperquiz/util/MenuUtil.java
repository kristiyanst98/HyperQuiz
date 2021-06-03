package hyperquiz.util;

import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.UserRepository;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.exceptions.InvalidGenderException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuUtil {
    public static void printMenu(QuizRepository qr, UserRepository ur) throws EntityAlreadyExistsException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:\n" +
                    "<0> Exit\n" +
                    "<1> Create Quiz\n" +
                    "<2> Create User\n" +
                    "<3> Print Quizzes\n" +
                    "<4> Print Users");
            int num = scanner.nextInt();
            switch (num) {
                case 0:
                    System.out.println("Quitting...");
                    return;
                case 1:
                    qr.create(QuizUtil.createQuiz());
                    break;
                case 2:
                    ur.create(UserUtil.createUser());
                    break;
                case 3:
                    printQuizzes(qr);
                    break;
                case 4:
                    printUsers(ur);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void printQuizzes(QuizRepository qr) {
        List<PrintUtil.ColumnDescriptor> metadataColumns = List.of(
                new PrintUtil.ColumnDescriptor("created", "Created", 10, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("updated", "Updated", 10, Alignment.CENTER)
        );

        List<PrintUtil.ColumnDescriptor> quizColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("id", "ID", 5, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("title", "Title", 8, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("author", "Author", 14, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("description", "Description", 20, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("expectedDuration", "Duration", 10, Alignment.RIGHT, 2),
                new PrintUtil.ColumnDescriptor("tags", "Tags", 11, Alignment.CENTER)
        ));

        quizColumns.addAll(metadataColumns);
        String quizReport = PrintUtil.formatTable(quizColumns, qr.findAll(), "Quiz List:");
        System.out.println(quizReport);
    }

    private static void printUsers(UserRepository ur) {
        List<PrintUtil.ColumnDescriptor> metadataColumns = List.of(
                new PrintUtil.ColumnDescriptor("created", "Created", 10, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("updated", "Updated", 10, Alignment.CENTER)
        );

        List<PrintUtil.ColumnDescriptor> userColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("username", "Username", 10, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("email", "E-mail", 10, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("gender", "Gender", 8, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("description", "Description", 20, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("status", "Status", 5, Alignment.RIGHT, 2)
        ));

        userColumns.addAll(metadataColumns);
        String userReport = PrintUtil.formatTable(userColumns, ur.findAll(), "Quiz List:");
        System.out.println(userReport);
    }
}
