package hyperquiz.util;

import hyperquiz.dao.UserRepository;
import hyperquiz.exceptions.InvalidGenderException;
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
    public static User createUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("=NOW CREATING A NEW USER=");
        do{
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            if(ValidationUtil.validateString(username,2,15)) {
                user.setUsername(username);
                break;
            }else{
                System.out.println("Username must contain from 2 to 15 characters");
            }
        }while(true);
        do {
            System.out.println("Enter e-mail:");
            String mail = scanner.nextLine();
            if(ValidationUtil.validateEmail(mail)){
            user.setEmail(mail);
            break;
            }else{
                System.out.println("Enter a valid email");
            }
        }while(true);
        do {
            System.out.println("Enter password:");
            String pw = scanner.nextLine();
            if (ValidationUtil.validateString(pw, 8, 15)) {
                user.setPassword(pw);
                break;
            }else{
                System.out.println("Enter a password between 8 and 15 characters");
            }
        }while(true);
        do {
            System.out.println("Enter a gender: M / F");
            String gender = scanner.nextLine();
            try {
                user.setGender(ValidationUtil.validateGender(gender));
            } catch (InvalidGenderException e) {
                System.out.println(e.getMessage());
            }
        } while (user.getGender() == null);
        do{
            System.out.println("Enter a user description:");
            String desc = scanner.nextLine();
            if(ValidationUtil.validateString(desc,20,250)){
                user.setDescription(desc);
                break;
            }else{
                System.out.println("Description should be between 20 and 250 characters");
            }
        }while(true);
        do{
            System.out.println("Enter metadata:");
            String meta = scanner.nextLine();
            if(ValidationUtil.validateString(meta,0,512)){
                user.setMetadata(meta);
                break;
            }
        }while(true);
        do{
            System.out.println("Should the account be active(Y/N):");
            String status = scanner.nextLine();
            if(ValidationUtil.validateStatus(user,status)){
                break;
            }else{
                System.out.println("Enter a valid status");
            }
        }while(true);

        return user;
    }
}
