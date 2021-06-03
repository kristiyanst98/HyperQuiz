package hyperquiz.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<Long,User> {
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

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(String username, String email, String password, Gender gender, boolean status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.status = status;
        this.quizzes=new ArrayList<>();
    }

    public User(String username, String email, String password, Gender gender, Role role, URL userPicture, String description, String metadata, boolean status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.userPicture = userPicture;
        this.description = description;
        this.metadata = metadata;
        this.status = status;
        this.quizzes=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public URL getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(URL userPicture) {
        this.userPicture = userPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.username);
        return sb.toString();
    }
}
