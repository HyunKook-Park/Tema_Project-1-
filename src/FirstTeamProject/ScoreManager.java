//package FirstTeamProject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//// 학생의 과목별 시험 회차 및 점수를 관리하는 클래스
//class ScoreManager {
//    private Map<String, Map<Integer, Integer>> studentScores; // 학생 ID와 (과목, 회차, 점수)를 저장하는 맵
//
//    // 생성자
//    public ScoreManager() {
//        studentScores = new HashMap<>();
//    }
//
//    // 학생의 점수를 등록하는 메서드
//    public void registerScore(String studentId, String subject, int round, int score) {
//        // 회차와 점수 검증
//        if (round < 1 || round > 10) {
//            throw new IllegalArgumentException("회차는 1에서 10 사이여야 합니다.");
//        }
//        if (score < 0 || score > 100) {
//            throw new IllegalArgumentException("점수는 0에서 100 사이여야 합니다.");
//        }
//
//        // 학생이 이미 등록되어 있는지 확인
//        studentScores.putIfAbsent(studentId, new HashMap<>());
//
//        Map<Integer, Integer> subjectScores = studentScores.get(studentId);
//
//        // 이미 등록된 회차 점수 확인
//        if (subjectScores.containsKey(round)) {
//            throw new IllegalArgumentException("해당 과목의 같은 회차 점수가 이미 등록되어 있습니다.");
//        }
//
//        // 점수 등록
//        subjectScores.put(round, score);
//    }
//
//    // 학생의 점수를 수정하는 메서드
//    public void updateScore(String studentId, String subject, int round, int newScore) {
//        // 회차와 점수 검증
//        if (round < 1 || round > 10) {
//            throw new IllegalArgumentException("회차는 1에서 10 사이여야 합니다.");
//        }
//        if (newScore < 0 || newScore > 100) {
//            throw new IllegalArgumentException("점수는 0에서 100 사이여야 합니다.");
//        }
//
//        // 학생과 과목의 점수를 조회하고 수정
//        Map<Integer, Integer> subjectScores = studentScores.get(studentId);
//        if (subjectScores == null || !subjectScores.containsKey(round)) {
//            throw new IllegalArgumentException("해당 과목의 같은 회차 점수가 등록되어 있지 않습니다.");
//        }
//
//        // 점수 수정
//        subjectScores.put(round, newScore);
//    }
//
//    // 학생의 특정 과목과 회차별 점수와 등급을 조회하는 메서드
//    public String getScoreGrade(String studentId, String subject, int round) {
//        Map<Integer, Integer> subjectScores = studentScores.get(studentId);
//        if (subjectScores == null || !subjectScores.containsKey(round)) {
//            return "해당 과목의 같은 회차 점수가 등록되어 있지 않습니다.";
//        }
//
//        int score = subjectScores.get(round);
//        String grade = getGrade(score);
//        return "회차: " + round + ", 점수: " + score + ", 등급: " + grade;
//    }
//
//    // 점수에 따른 등급을 반환하는 메서드
//    private String getGrade(int score) {
//        if (score >= 90) return "A";
//        if (score >= 80) return "B";
//        if (score >= 70) return "C";
//        if (score >= 60) return "D";
//        return "F";
//    }
//}