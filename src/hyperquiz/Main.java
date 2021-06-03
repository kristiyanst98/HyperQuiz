package hyperquiz;

import hyperquiz.dao.QuizRepository;
import hyperquiz.dao.impl.LongKeyGenerator;
import hyperquiz.dao.impl.QuizRepositoryImpl;
import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.model.Quiz;
import hyperquiz.model.User;
import hyperquiz.util.Alignment;
import hyperquiz.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EntityAlreadyExistsException {
        Quiz quiz = new Quiz();
        Quiz quiz2 = new Quiz();
        User user = new User();
        user.setUsername("Ivan Ivanov");
        quiz.setAuthor(user);
        quiz2.setAuthor(user);
        quiz.setDescription("Easy one");
        quiz2.setDescription("Getting complicated");
        quiz.setExpectedDuration(1);

        QuizRepository quizRepository = new QuizRepositoryImpl(new LongKeyGenerator());
        Quiz[] quizz ={quiz,quiz2};


        List<PrintUtil.ColumnDescriptor> metadataColumns = List.of(
                new PrintUtil.ColumnDescriptor("created", "Created", 10, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("updated", "Updated", 10, Alignment.CENTER)
        );

        List<PrintUtil.ColumnDescriptor> quizColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("id", "ID", 5, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("title", "Title", 5, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("author", "Author", 10, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("description", "Description", 12, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("expectedDuration", "Duration", 8, Alignment.RIGHT, 2),
                new PrintUtil.ColumnDescriptor("URL", "Picture URL", 11, Alignment.CENTER)
        ));

        quizColumns.addAll(metadataColumns);

        String quizReport = PrintUtil.formatTable(quizColumns, quizRepository.findAll(), "Quiz List:");
        System.out.println(quizReport);
    }
}
