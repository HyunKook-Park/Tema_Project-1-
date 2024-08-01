package FirstTeamProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Student {

    // 수강생 목록 컬렉션
    private Map<String, String> StudentList = new HashMap<>();

    // 수강생 상세정보 컬렉션
    private Map<String, String> StudentProfile = new HashMap<>();
    private String StudentName;
    private String UniqueId;

    // 수강색 이름, 고유번호 등록메서드
    public void ListSet(String StudentName, String UniqueId) {
        this.StudentName = StudentName;
        this.UniqueId = UniqueId;
        StudentList.put(this.StudentName, this.StudentName + "-" + this.UniqueId);

    }

    // 수강생 상세정보 등록 메서드
    public void ProfileSet(String UniqueId, String[] Subject) {
        StudentProfile.put(UniqueId, Arrays.toString(Subject));
    }

    // 수강생 고유번호 조회 메서드
    public String getUniqueId(String StudentName) {
        return StudentList.get(StudentName);
    }

    // 수강생 상세정보 조회 메서드
    public String ProfileGet(String UniqueId) {
        return "과목 목록 : " + StudentProfile.get(UniqueId);
    }


    /* 테스트용 코드
   public static void main(String[] args) {
        Student temp = new Student();
        String[] Subject = {"Java","객체지향","Spring"};
        temp.ListSet("최원용","13579");
        temp.getUniqueId("최원용");
        temp.ProfileSet("13579", Subject);
        System.out.println(temp.ProfileGet("13579"));
    }
    */


}
