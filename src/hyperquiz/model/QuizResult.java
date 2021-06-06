package hyperquiz.model;

public class QuizResult extends AbstractEntity<Long,QuizResult>{
    private Player player;
    private Quiz quiz;
    private int score;

    public QuizResult() {
    }

    public QuizResult(Player player, Quiz quiz, int score) {
        this.player = player;
        this.quiz = quiz;
        this.score = score;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuizResult{");
        sb.append("player=").append(player);
        sb.append(", quiz=").append(quiz);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
