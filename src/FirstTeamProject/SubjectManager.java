package FirstTeamProject;

import java.util.HashMap;
import java.util.Map;

public class SubjectManager {
    //과목 이름 저장하는 *변수*
    private String name;
    //회차를 키로 하고 점수를 값으로 하는 점수 저장 맵
    private Map<Integer, Integer> scores;
    //Subject 클래스의 생성자
    public SubjectManager(String name){
        this.name = name; //과목 이름 초기화
        this.scores = new HashMap<>(); //점수를 저장할 맵 초기화
    }

    //Enum정의
    public enum SubjectType{//열거형
        REQUIRED,
        ELECTIVE
    }





}
