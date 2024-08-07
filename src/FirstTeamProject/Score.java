package FirstTeamProject;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;
    private int score;

    public Score(String scoreId, String studentId, String subjectId, int score) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }

    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
