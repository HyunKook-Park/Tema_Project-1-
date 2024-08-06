package FirstTeamProject;

import java.util.ArrayList;
import java.util.List;

// StudentManager 클래스: 학생 목록을 관리하는 클래스
class StudentManager {
    private List<Student> students; // 학생 목록을 저장하는 리스트

    // 생성자: 학생 목록 리스트를 초기화
    public StudentManager() {
        students = new ArrayList<>();
    }

    // 학생을 리스트에 추가하는 메서드
    public void addStudent(Student student) {
        students.add(student);
    }

    // 모든 학생을 출력하는 메서드
    public void listStudents() {
        // 학생 목록이 비어 있는 경우
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        // 학생 목록을 출력
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}