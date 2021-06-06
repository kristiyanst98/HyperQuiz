package hyperquiz.util;

import hyperquiz.dao.KeyGenerator;
import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.QuizResultRepository;
import hyperquiz.dao.UserRepository;
import hyperquiz.dao.impl.LongKeyGenerator;
import hyperquiz.model.Player;
import hyperquiz.model.Question;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

    private static ObjectOutputStream OUT;
    private static LongKeyGenerator keyGen=new LongKeyGenerator();

    static {
        try {
            if(Files.exists(Path.of("Entities.data"))){
                List<User> users = MenuUtil.readUsers();
                List<Quiz> quizzes=MenuUtil.readQuizzes();
                OUT = new ObjectOutputStream(new FileOutputStream("Entities.data"));
                for(User user:users){
                    OUT.writeObject(user);
                }
                for(Quiz q:quizzes){
                    OUT.writeObject(q);
                }
            }else{
                OUT = new ObjectOutputStream(new FileOutputStream("Entities.data"));
            }


        } catch (IOException e) {

        }
    }
    public static LongKeyGenerator getKeyGen() {
        if (Files.exists(Path.of("Entities.data"))) {
            try (ObjectInputStream IN = new ObjectInputStream(new FileInputStream("Entities.data"))) {
                Object obj;
                while ((obj = IN.readObject()) != null) {
                    if (obj instanceof LongKeyGenerator) {
                        keyGen = (LongKeyGenerator) obj;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {

            }
        }
        return keyGen;
    }
    public static void createUser(User user) {
        try {
            OUT.writeObject(user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createQuiz(Quiz quiz) {
        try {
            OUT.writeObject(quiz);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
