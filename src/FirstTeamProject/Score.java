package FirstTeamProject;

public class Score {
    private int round; // 시험 회차
    private int score; // 점수
    private String grade; // 등급

    public Score(int round, int score) {
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("회차는 1에서 10 사이여야 합니다.");
        }
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0에서 100 사이여야 합니다.");
        }
        this.round = round;
        this.score = score;
        this.grade = calculateGrade(score);
    }

    public int getRound() {
        return round;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    private String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return "Round: " + round + ", Score: " + score + ", Grade: " + grade;
    }
}
