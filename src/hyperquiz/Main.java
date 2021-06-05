package hyperquiz;

import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.UserRepository;
import hyperquiz.dao.impl.LongKeyGenerator;
import hyperquiz.dao.impl.QuizRepositoryImpl;
import hyperquiz.dao.impl.UserRepositoryMemoryImpl;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;
import hyperquiz.util.Alignment;
import hyperquiz.util.MenuUtil;
import hyperquiz.util.PrintUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EntityAlreadyExistsException, IOException, ClassNotFoundException {
//        Quiz quiz = new Quiz();
//        Quiz quiz2 = new Quiz();
//        User user = new User();
//        user.setUsername("Georgi Ivanov");
//        quiz.setAuthor(user);
//        quiz.setDescription("Easy one");
//        quiz.setExpectedDuration(1);
//        quiz.setId(1L);
//        quiz.setTitle("Easy");
//        User user2=new User();
//        user2.setUsername("John Doe");
//        quiz2.setAuthor(user2);
//        quiz2.setDescription("Getting complicated");
//        quiz2.setId(2L);
//        quiz2.setTitle("Medium");

//        QuizRepository quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
//        UserRepository userRepository = new UserRepositoryMemoryImpl(new LongKeyGenerator());
//        String quizReport = PrintUtil.formatTable(quizColumns, Arrays.asList(quizz), "Quiz List:");
//        System.out.println(quizReport);

        MenuUtil.printMenu();

    }
}
