package hyperquiz.dao.impl.test;

import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.UserRepository;
import hyperquiz.dao.impl.LongKeyGenerator;
import hyperquiz.dao.impl.QuizRepositoryImpl;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.model.Gender;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuizRepositoryImplTest {

    private static final List<Quiz> QUIZZES = List.of(
            new Quiz("quiz1", new User(), "quiz@A1",5,"#tag1"),
            new Quiz("quiz2", new User(), "quiz@A2",4,"#tag2"),
            new Quiz("quiz3", new User(), "quiz@A3",1,"#tag3"),
            new Quiz("quiz4", new User(), "quiz@A4",2,"#tag4"),
            new Quiz("quiz5", new User(), "quiz@A5",3,"#tag5")
    );
    private QuizRepository qr;
    private LongKeyGenerator keyGenerator;

    @BeforeEach
    public void setUp(){
        keyGenerator=new LongKeyGenerator();
        qr=new QuizRepositoryImpl(keyGenerator);

    }

    private void fillInQuizzes() {
        QUIZZES.forEach((u) -> {
                    try {
                        qr.create(u);
                    } catch (EntityAlreadyExistsException | IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Test
    void findByExpectedDuration() {
        fillInQuizzes();
        Optional<Quiz> quiz = qr.findByExpectedDuration(5);
        assertNotEquals(null,quiz,"Quiz found by expected duration is null");
    }

    @Test
    void findByTitle() {
        fillInQuizzes();
        Optional<Quiz> quiz = qr.findByTitle("quiz4");
        assertNotEquals(null,quiz,"Quiz found by title is null");
    }

    @Test
    void findByDescription() {
        fillInQuizzes();
        Optional<Quiz> quiz = qr.findByDescription("quiz@A3");
        assertNotEquals(null,quiz,"Quiz found by description is null");
    }

    @Test
    void findByTags() {
        fillInQuizzes();
        Optional<Quiz> quiz = qr.findByTags("#tag1");
        assertNotEquals(null,quiz,"Quiz found by tags is null");
    }

    @Test
    void findByTTD() {
        fillInQuizzes();
        Set<Quiz> quiz = qr.findByTTD("quiz3");
        assertNotEquals(null,quiz,"Set of quizzes is null");
    }
}