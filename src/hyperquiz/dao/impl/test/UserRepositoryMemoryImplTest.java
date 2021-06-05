package hyperquiz.dao.impl.test;

import hyperquiz.dao.UserRepository;
import hyperquiz.dao.impl.LongKeyGenerator;
import hyperquiz.dao.impl.UserRepositoryMemoryImpl;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.model.Gender;
import hyperquiz.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryMemoryImplTest {
    private static final List<User> USERS = List.of(
            new User("user1", "user1@abv.bg", "password@A5", Gender.MALE, true),
            new User("user2", "user2@abv.bg", "password@A5", Gender.MALE, true),
            new User("user3", "user3@abv.bg", "password@A5", Gender.FEMALE, true),
            new User("user4", "user4@abv.bg", "password@A5", Gender.MALE, true),
            new User("user5", "user5@abv.bg", "password@A5", Gender.FEMALE, true)
    );
    private UserRepository ur;
    private LongKeyGenerator keyGenerator;

    @BeforeEach
    public void setUp(){
        keyGenerator=new LongKeyGenerator();
        ur=new UserRepositoryMemoryImpl(keyGenerator);
    }
    private void fillInUsers() {
        USERS.forEach((u) -> {
                    try {
                        ur.create(u);
                    } catch (EntityAlreadyExistsException | IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Test
    void findByUsername() {
        fillInUsers();
        Optional<User> user = ur.findByUsername("user1");
        assertNotEquals(null,user,"User not found");
    }
    @Test
    void create(){
       assertDoesNotThrow(()->ur.create(USERS.get(2)));
    }
    @Test
    void update(){

    }
    @Test
    void findAll(){
        fillInUsers();
        List<User> users=new ArrayList<>(ur.findAll());
        assertNotEquals(null,users);
        assertEquals(ur.findAll(),users);
        assertEquals(ur.findAll().get(1),users.get(1));
    }
    @Test
    void findById(){
        fillInUsers();
        Optional<User> user = ur.findById(2L);
        assertNotEquals(null,user);
        assertEquals(ur.findByUsername("user2"),user);

    }
    @Test
    void deleteById(){
        fillInUsers();
        assertDoesNotThrow(()->ur.deleteById(2L));
    }
    @Test
    void count(){
        fillInUsers();
        long count = ur.count();
        assertEquals(USERS.size(),count);
    }
}