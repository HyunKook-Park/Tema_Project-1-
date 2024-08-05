package FirstTeamProject;

import java.util.*;


class main {
    public static void main(String[] args) {
        // 수강생 상세정보 리스트
        Map<String, ArrayList<Student>> studentList = new HashMap<>();
        ArrayList<Student> studentProfile = new ArrayList<>();


        studentProfile.add(new Student("1", "최원용", "자바"));
        studentList.put("최원용",studentProfile);


        // 수강생 과목 조회
        studentList.get("최원용").stream().
                forEach(f -> System.out.println("수강생 아이디: " + f.getId()));
        
        // 수강생 아이디 조회
        studentList.get("최원용").stream().
                forEach(f -> System.out.println("선택과목 : " + f.getSubject()));

        // 수강생 이름 조회
        studentList.get("최원용").stream().
                forEach(f -> System.out.println("수강생 이름 : " + f.getStudentName()));
    }
}


public class Student {
    final private String UNIQUEID;
    private String StudentName;
    private String Subject;

    public Student(String UNIQUEID, String StudentName, String Subject) {
        this.UNIQUEID = UNIQUEID;
        this.StudentName = StudentName;
        this.Subject = Subject;
    }

    public String getId() {
        return this.UNIQUEID;
    }

    public String getStudentName(){
        return this.StudentName;
    }

    public String getSubject(){
        return this.Subject;
    }

}

