package hyperquiz.util;

import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.UserRepository;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;

import java.io.*;
import java.util.*;

public class MenuUtil {
    public static final String SELECT_OPTION = "Select an option:";
    private static final String EXIT_OPTION = "<0> Exit";
    public static final String LOGIN_OPTION = "<1> Login";
    public static final String REGISTER_OPTION = "<2> Register";
    public static final String PRINT_USER_OPTION = "<1> Print Users";
    public static final String PRINT_QUIZ_OPTION = "<2> Print Quizzes";
    public static final String CREATE_QUIZ_OPTION ="<3> Create Quiz";
    private static Map<Integer, String> options = new LinkedHashMap<>();
    private static ObjectInputStream IN;
    private static Map<Integer, String> loggedOpt = new LinkedHashMap<>();


    public static void printMenu() {
        options.put(0, EXIT_OPTION);
        options.put(1, LOGIN_OPTION);
        options.put(2, REGISTER_OPTION);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(SELECT_OPTION);
            for (Map.Entry<Integer, String> opt : options.entrySet()) {
                System.out.println(opt.getValue());
            }
            int num = scanner.nextInt();
            switch (num) {
                case 0:
                    System.out.println("Quitting...");
                    return;
                case 1:
                    login();
                    break;

                case 2:
                    StreamUtil.createUser(UserUtil.createUser());
                    break;
                case 4:
                    printUsers();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void printQuizzes() {
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
        String quizReport = PrintUtil.formatTable(quizColumns, readQuizzes(), "Quiz List:");
        System.out.println(quizReport);

    }

    public static void printUsers() {
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
        String userReport = PrintUtil.formatTable(userColumns, readUsers(), "User List:");
        System.out.println(userReport);
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();


        Object obj;
        try {
            IN = new ObjectInputStream(new FileInputStream("Entities.data"));
            while ((obj = IN.readObject()) != null) {
                if (obj instanceof User) {
                    users.add((User) obj);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Reached EOF");
        }
        return users;
    }

    public static List<Quiz> readQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();

//        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Entities.data"))) {
        Object obj;
        try {
            IN=new ObjectInputStream(new FileInputStream("Entities.data"));
            while ((obj = IN.readObject()) != null) {
                if (obj instanceof Quiz) {
                    quizzes.add((Quiz) obj);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Reached EOF");
        }

        return quizzes;
    }


    public static boolean login() {
        List<User> users;
        Scanner scanner = new Scanner(System.in);
        users = readUsers();

        while (true) {
            System.out.println("Enter username or 0 to quit:");
            String username = scanner.nextLine();
            if (username.equals("0")) {
                break;
            } else {
                for (User user : users) {
                    if (user.getUsername().equals(username)) {
                        System.out.println("Enter password:");
                        String password = scanner.nextLine();
                        if (password.equals(user.getPassword())) {
                            System.out.println("Login successful!");
                            printLoggedOpt();
                            break;
                        } else {
                            System.out.println("Login failed.Wrong password");
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void printLoggedOpt() {
        loggedOpt.put(0, EXIT_OPTION);
        loggedOpt.put(1, PRINT_USER_OPTION);
        loggedOpt.put(2, PRINT_QUIZ_OPTION);
        loggedOpt.put(3,CREATE_QUIZ_OPTION);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(SELECT_OPTION);
            for (Map.Entry<Integer, String> opt : loggedOpt.entrySet()) {
                System.out.println(opt.getValue());
            }
            int num = scanner.nextInt();
            switch (num) {
                case 0:
                    System.out.println("Quitting...");
                    return;
                case 1:
                    printUsers();
                    break;
                case 2:
                    printQuizzes();
                    break;
                case 3:
                    StreamUtil.createQuiz(QuizUtil.createQuiz());
                    break;
                default:
                    System.out.println("Invalid Option");

            }
        }
    }
    public static void playQuiz(){

    }
}
