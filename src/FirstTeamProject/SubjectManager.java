package FirstTeamProject;

import java.util.HashMap;
import java.util.Map;

public class SubjectManager {

    //과목 이름 저장하는 변수
    private String name;
    //    과목 저장 맵
    private Map<String, Subject> subjects;


    //Subject 클래스의 생성자
    public SubjectManager(String name){
        this.name = name; //과목 이름 초기화
        this.subjects = new HashMap<>();
    }

    //    과목을 추가하는 메서드
    public void addSubject(Subject subject){
        subjects.put(subject.getId(), subject);
    }

    //    과목을 ID로 찾는 메서드
    public Subject getSubjectById(String id){
        return subjects.get(id);
    }

//    필수X
//    // Getter 메서드
//    //    SUbjectManager 객체의 이름을 반환함
//    //    객체에 대한 *정보*를 쉽게 확인할 수 있게 합
//    public String getName() {
//        return name;
//    }

    //    출력
    public void printAllSubjects(){
        for (Subject subject : subjects.values()){
            System.out.println("과목 ID" + subject.getId() + ".과목명:" + subject.getName() + ", 과목 유형: " + subject.getType().toString());
        }
    }







}
