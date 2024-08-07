package FirstTeamProject;

import FirstTeamProject.Subject;
import FirstTeamProject.SubjectManager;

public class Main {
    public static void main(String[] args) {
        // SubjectManager 객체 생성
        SubjectManager manager = new SubjectManager("Course Manager");

        // Subject 객체 생성
        Subject math = new Subject("001", "Mathematics", Subject.SubjectType.REQUIRED);
        Subject science = new Subject("002", "Science", Subject.SubjectType.ELECTIVE);

        // 과목 추가
        manager.addSubject(math);
        manager.addSubject(science);

        // 모든 과목 출력
        manager.printAllSubjects();

        // StudentManager 객체를 생성
        StudentManager studentManager = new StudentManager();

        // 학생을 추가
        studentManager.addStudent(new Student("1", "Alice"));
        studentManager.addStudent(new Student("2", "Bob"));
        studentManager.addStudent(new Student("3", "Charlie"));

        // 학생 목록을 출력
        studentManager.listStudents();

        // ScoreManager 객체를 생성
        ScoreManager scoreManager = new ScoreManager();

        // 학생의 점수를 등록
        scoreManager.registerScore("student1", "Math", 1, 95);
        scoreManager.registerScore("student1", "Math", 2, 82);

        // 점수를 조회
        System.out.println(scoreManager.getScoreGrade("student1", "Math", 1));
        System.out.println(scoreManager.getScoreGrade("student1", "Math", 2));

        // 점수 수정
        scoreManager.updateScore("student1", "Math", 2, 85);

        // 수정된 점수를 조회
        System.out.println(scoreManager.getScoreGrade("student1", "Math", 2));
    }
    }

