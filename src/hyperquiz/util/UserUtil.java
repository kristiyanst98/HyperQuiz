package hyperquiz.util;

import hyperquiz.dao.UserRepository;
import hyperquiz.model.Gender;
import hyperquiz.model.Quiz;
import hyperquiz.model.Role;
import hyperquiz.model.User;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class UserUtil {
    private String username;
    private String email;
    private String password;
    private Gender gender;
    private Role role=Role.PLAYER;
    private URL userPicture;
    private String description;
    private String metadata;
    private boolean status;
    private List<Quiz> quizzes;
    public static User createUser(UserRepository ur){
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("=NOW CREATING A NEW USER=");
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println("Enter e-mail:");
        String mail = scanner.nextLine();
        user.setEmail(mail);
        System.out.println("Enter password:");
        String pw = scanner.nextLine();
        user.setPassword(pw);
        System.out.println("Enter a gender: M / F");
        String gender = scanner.nextLine();
    }
}
