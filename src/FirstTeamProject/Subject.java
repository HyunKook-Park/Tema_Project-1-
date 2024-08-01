package FirstTeamProject;

//데이터만 작업
//과목의 기본 정보를 저장하는 데이터 모델
public class Subject{

    private String id; //과목 ID(식별자)
    private String name; //과목 이름
    private String type; //과목 유형 (예: "과학", "역사", "수학" 등) 고
    //생성자 this 현재 객체 가리킴
    public Subject(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;

    }

    //getter 메서드 = id, name, type에 *접근* 할 수 있도록 함
//setter메서드 = id, name, type 값을 *설정* 할 수 있도록 함
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

