//package FirstTeamProject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// StudentManager 클래스: 학생 목록을 관리하는 클래스
//public class StudentManager {
//    private List<Student> students = new A; // 학생 목록을 저장하는 리스트
//
//    // 생성자: 학생 목록 리스트를 초기화
//    public StudentManager() {
//        students = new ArrayList<>();
//    }
//
//    // 학생을 리스트에 추가하는 메서드
//    public void addStudent(Student student) {
//        students.add(student);
//    }
//
//    // 모든 학생을 출력하는 메서드
//    public void listStudents() {
//        // 학생 목록이 비어 있는 경우
//        if (students.isEmpty()) {
//            System.out.println("No students found.");
//            return;
//        }
//        // 학생 목록을 출력
//        System.out.println("Student List:");
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//    }
//    // 특정 학생을 ID로 검색하는 메서드
//    public Student getStudentById(String studentId) {
//        for (Student student : students) {
//            if (student.getId().equals(studentId)) {
//                return student;
//            }
//        }
//        return null; // 학생이 발견되지 않았을 때
//    }
//
//    // 학생의 정보 수정 메서드
//    public boolean updateStudent(String studentId, String newName) {
//        Student student = getStudentById(studentId);
//        if (student != null) {
//            student.setName(newName); // 학생 이름 수정
//            return true; // 수정 성공
//        }
//        return false; // 학생이 발견되지 않음
//    }
//
//    // 학생 삭제 메서드
//    public boolean deleteStudent(String studentId) {
//        Student student = getStudentById(studentId);
//        if (student != null) {
//            students.remove(student); // 학생 목록에서 제거
//            return true; // 삭제 성공
//        }
//        return false; // 학생이 발견되지 않음
//    }
//}
