package FirstTeamProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Subject {
    private String subjectId;
    private String subjectName;
    private String subjectType;

    // 생성자
    public Subject(String subjectId, String subjectName, String subjectType) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    // Getter 메서드
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    // 과목 선택 메서드
    public static List<String> selectSubjects(String type, int count, List<Subject> subjects) {
        List<String> subjectList = new ArrayList<>();
        List<Subject> filteredSubjects = subjects.stream()
                .filter(subject -> subject.getSubjectType().equals(type))
                .collect(Collectors.toList());

        for (int i = 0; i < filteredSubjects.size(); i++) {
            System.out.println((i + 1) + ". " + filteredSubjects.get(i).getSubjectName());
        }
        System.out.println("과목을 선택하세요 (번호 입력): ");

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            int input = sc.nextInt();
            if (input < 1 || input > filteredSubjects.size()) {
                System.out.println("잘못된 입력입니다.");
                i--; // 잘못된 입력일 경우 다시 입력 받기
                continue;
            }
            subjectList.add(filteredSubjects.get(input - 1).getSubjectName());
        }
        return subjectList;
    }

    // main 메서드는 클래스의 기능을 테스트하는 용도로 사용
    public static void main(String[] args) {
        // 예시: Subject 객체 생성 및 selectSubjects 메서드 호출
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("SU001", "Java", "MANDATORY"));
        subjects.add(new Subject("SU002", "Spring", "MANDATORY"));
        subjects.add(new Subject("SU003", "Design Patterns", "CHOICE"));

        List<String> selectedSubjects = selectSubjects("MANDATORY", 2, subjects);
        System.out.println("선택된 필수 과목: " + selectedSubjects);
    }
}
