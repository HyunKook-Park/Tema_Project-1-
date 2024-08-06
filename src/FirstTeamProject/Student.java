package FirstTeamProject;

import java.util.Scanner;
import java.util.*;


class manager {
    public static void main(String[] args) {
        // 스캐너 인스턴스생성
        Scanner sc = new Scanner(System.in);


        // 수강생 데이터
        Map<String, Student> studentList = new HashMap<>();
//      Student studentProfile = new Student;

        // 과목 데이터
        final List<Subject1> subjectList = List.of(
                new Subject1("1", "Java", "Main"),
                new Subject1("2", "객체지향", "Main"),
                new Subject1("3", "Spring", "Main"),
                new Subject1("4", "JPA", "Main"),
                new Subject1("5", "MySQL", "Main"),
                new Subject1("6", "디자인 패턴", "Sub"),
                new Subject1("7", "Spring Security", "Sub"),
                new Subject1("8", "Redis", "Sub"),
                new Subject1("9", "MongoDB", "Sub")
        );


        boolean flag = true;
        while (flag) {
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 관리");
            System.out.println("3. 수강생 목록 조회");
            int input = sc.nextInt();
            int idNum = 0;
            int index = 0;
            switch (input) {
                case 1:
                    // 수강생 등록 메서드
                    int UNIQUEID = ++idNum;
                    System.out.println("수강생 이름을 입력하세요");
                    String studentName = sc.next();
                    System.out.println();
                    System.out.println("Java : 1, " + "Type : Main");
                    System.out.println("객체지향 : 2, " + "Type : Main");
                    System.out.println("Spring : 3, " + "Type : Main");
                    System.out.println("JPA : 4, " + "Type : Main");
                    System.out.println("MySQL : 5, " + "Type : Main");
                    System.out.println("디자인 패턴 : 6, " + "Type : Sub");
                    System.out.println("Spring Security : 7, " + "Type : Sub");
                    System.out.println("Redis : 8, " + "Type : Sub");
                    System.out.println("MongoDB : 9, " + "Type : Sub");
                    System.out.println();
                    System.out.println("선택할 과목의 번호를 입력하세요");
                    String selctNum = sc.next();
                    List<Subject1> Subject = subjectList.stream().
                            filter(subject -> subject.getSubjectId().equals(selctNum)).toList();
                    studentList.put(studentName, new Student(UNIQUEID, studentName, Subject));

                    System.out.println("수강생 등록 완료");
                    break;

                case 2:
                    System.out.println("조회가 필요한 수강생 이름을 입력하세요");
                    System.out.println();
                    String inputName = sc.next();
                    System.out.println(studentList.get(inputName).toString());
                    break;

                case 3:
                    // 수강생 명단 조회
                    System.out.println("---------------수강생 명단---------------");
                    for(String List : studentList.keySet()){
                        System.out.println(List);
                    }
                    break;

            }
            System.out.println("계속 조회하시겠습니까? (exit입력시 종료)");
            String restart = sc.next();
            if(restart.equals("exit")){
                System.out.println("<수강생 관리 프로그램 종료>");
                flag = !flag;
            }
        }

    }
}


class Student {


    private int UNIQUEID;
    private String StudentName;
    private List<Subject1> Subject;


    public Student(int UNIQUEID, String StudentName, List<Subject1> Subject) {
        this.UNIQUEID = UNIQUEID;
        this.StudentName = StudentName;
        this.Subject = Subject;
    }

    public int getId() {
        return this.UNIQUEID;
    }

    public String getStudentName() {
        return this.StudentName;
    }

    public List<Subject1> getSubject() {
        return this.Subject;
    }


    @Override
    public String toString() {
        return "UNIQUEID: " + UNIQUEID +
                ", StudentName: " + StudentName +
                ", Subject: " + Subject.stream().
                map(Subject1::getSubjectName).toList() +
                ", Type: " + Subject.stream().
                map(Subject1::getType).toList();
    }

}

class Subject1 {

    private String subjectId;
    private String subjectName;
    private String Type;


    public Subject1(String subjectId, String subjectName, String Type) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.Type = Type;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getType() {
        return Type;
    }


//

}


class Score1 {
    public Score1() {

    }
}