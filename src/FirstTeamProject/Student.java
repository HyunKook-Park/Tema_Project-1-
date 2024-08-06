package FirstTeamProject;

import java.util.*;

public class Student {
    private String id; // 수강생 ID
    private String name; // 수강생 이름
    private List<Subject> subjects; // 수강 과목 목록
    private Map<Subject, List<Score>> scores; // 과목별 점수 목록

    // 기본 생성자: 과목 목록 없이 초기화
    public Student(String id, String name) {
        this(id, name, new ArrayList<>());
    }
    //생성자:student 객체를 초기화
    public Student(String id, String name, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.scores = new HashMap<>();
//        수강과목 목록에 대해 각 과목에 대한 점수를 저장할 리스크를 초기화
        for (Subject subject : subjects) {
            scores.put(subject, new ArrayList<>());
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Map<Subject, List<Score>> getScores() {
        return scores;
    }


        // 학생 정보를 문자열로 반환 (ID와 이름 포함)
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name;
        }
    }

