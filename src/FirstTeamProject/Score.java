package FirstTeamProject;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectName;
    private int round;
    private int score;
    private String status;

    public Score(String scoreId, String studentId, String subjectName, int round, int score) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.round = round;
        this.score = score;
        this.status = "Green";
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getRound() {
        return round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId='" + scoreId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", score=" + score +
                ", round=" + round +
                '}';
    }
}
