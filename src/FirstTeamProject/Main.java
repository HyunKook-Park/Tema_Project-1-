package FirstTeamProject;

//import javax.security.auth.Subject;
import java.util.*;

// Main 클래스는 프로그램의 진입점입니다.
public class Main {
    // Scanner 객체를 통해 사용자 입력을 받습니다.
    static Scanner sc = new Scanner(System.in);

    // 학생 정보를 저장하는 리스트
    private static List<Student> studentStore;
    // 과목 정보를 저장하는 리스트
    private static List<Subject> subjectStore;
    // 점수 정보를 저장하는 리스트
    private static List<Score> scoreStore;

    // 과목 유형 상수 정의
    private static final String SUBJECT_TYPE_MANDATORY = "MANDATORY"; // 필수 과목
    private static final String SUBJECT_TYPE_CHOICE = "CHOICE"; // 선택 과목

    // 학생, 과목, 점수 ID 생성을 위한 인덱스와 접두사
    private static int studentIndex = 0;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex = 0;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex = 0;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 프로그램 시작 시 호출되는 메서드
    public static void main(String[] args) {
        setInitData(); // 초기 데이터 설정
        try {
            displayMainView(); // 메인 화면 표시
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 설정 메서드
    private static void setInitData() {
        studentStore = new ArrayList<>(); // 학생 저장소 초기화
        // 과목 저장소 초기화 (ImmutableList 사용)
        subjectStore = List.of(
                new Subject(sequence(INDEX_TYPE_SUBJECT), "Java", SUBJECT_TYPE_MANDATORY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "객체지향", SUBJECT_TYPE_MANDATORY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring", SUBJECT_TYPE_MANDATORY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "JPA", SUBJECT_TYPE_MANDATORY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "MySQL", SUBJECT_TYPE_MANDATORY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "디자인 패턴", SUBJECT_TYPE_CHOICE),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring Security", SUBJECT_TYPE_CHOICE),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "Redis", SUBJECT_TYPE_CHOICE),
                new Subject(sequence(INDEX_TYPE_SUBJECT), "MongoDB", SUBJECT_TYPE_CHOICE)
        );
        scoreStore = new ArrayList<>(); // 점수 저장소 초기화
    }

    // ID 생성 메서드
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            case INDEX_TYPE_SCORE -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
        return type; // 기본 값 반환
    }

    // 메인 화면 표시 메서드
    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");

            int input = sc.nextInt(); // 사용자 입력 받기
            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000); // 2초 대기
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 수강생 ID 입력 메서드
    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next(); // 사용자 입력 받기
    }

    // 수강생 관리 화면 표시 메서드
    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 상태 관리");
            System.out.println("4. 수강생 정보 조회");
            System.out.println("5. 수강생 정보 수정");
            System.out.println("6. 상태별 수강생 목록 조회");
            System.out.println("7. 수강생 삭제");
            System.out.println("8. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> manageStudentStatus(); // 수강생 상태 관리
                case 4 -> viewStudentInfo(); // 수강생 정보 조회
                case 5 -> updateStudentInfo(); // 수강생 정보 수정
                case 6 -> viewStudentsByStatus(); // 상태별 수강생 목록 조회
                case 7 -> deleteStudent(); // 수강생 삭제
                case 8 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                }
            }
        }
    }

    // 점수 관리 화면 표시 메서드
    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 점수 등록");
            System.out.println("2. 점수 목록 조회");
            System.out.println("3. 점수 수정");
            System.out.println("4. 점수 삭제");
            System.out.println("5. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 점수 등록
                case 2 -> inquireScore(); // 점수 목록 조회
                case 3 -> updateScore(); // 점수 수정
                case 4 -> deleteScore(); // 점수 삭제
                case 5 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                }
            }
        }
    }

    // 수강생 등록 메서드
    private static void createStudent() {
        System.out.print("\n수강생 이름을 입력하시오...");
        String studentName = sc.next();
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);
        studentStore.add(student);
        System.out.println(studentName + "님이 등록되었습니다.");
    }

    // 수강생 목록 조회 메서드
    private static void inquireStudent() {
        System.out.println("\n수강생 목록 조회");
        studentStore.forEach(student -> System.out.printf("ID: %s, 이름: %s, 상태: %s%n",
                student.getStudentId(), student.getStudentName(), student.getStatus()));
    }

    // 수강생 상태 관리 메서드
    private static void manageStudentStatus() {
        String studentId = getStudentId();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("현재 상태: " + student.getStatus());
            System.out.println("변경할 상태를 입력하세요 (수강중, 수강완료, 수강포기):");
            String newStatus = sc.next();
            student.setStatus(newStatus);
            System.out.println("상태가 변경되었습니다.");
        } else {
            System.out.println("수강생을 찾을 수 없습니다.");
        }
    }

    // 수강생 정보 조회 메서드
    private static void viewStudentInfo() {
        String studentId = getStudentId();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.printf("ID: %s, 이름: %s, 상태: %s, 등록 과목: %s%n",
                    student.getStudentId(), student.getStudentName(), student.getStatus(),
                    student.getEnrolledSubjectIds());
        } else {
            System.out.println("수강생을 찾을 수 없습니다.");
        }
    }

    // 수강생 정보 수정 메서드
    private static void updateStudentInfo() {
        String studentId = getStudentId();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.print("새 이름을 입력하시오...");
            String newName = sc.next();
            student.setStudentName(newName);
            System.out.println("이름이 변경되었습니다.");
        } else {
            System.out.println("수강생을 찾을 수 없습니다.");
        }
    }

    // 상태별 수강생 목록 조회 메서드
    private static void viewStudentsByStatus() {
        System.out.println("조회할 상태를 입력하세요 (수강중, 수강완료, 수강포기):");
        String status = sc.next();
        studentStore.stream()
                .filter(student -> status.equals(student.getStatus()))
                .forEach(student -> System.out.printf("ID: %s, 이름: %s%n",
                        student.getStudentId(), student.getStudentName()));
    }

    // 수강생 삭제 메서드
    private static void deleteStudent() {
        String studentId = getStudentId();
        Student student = findStudentById(studentId);

        if (student != null) {
            studentStore.remove(student);
            System.out.println("수강생이 삭제되었습니다.");
        } else {
            System.out.println("수강생을 찾을 수 없습니다.");
        }
    }

    // 점수 등록 메서드
    private static void createScore() {
        System.out.print("\n학생 ID를 입력하시오...");
        String studentId = sc.next();
        System.out.print("과목 ID를 입력하시오...");
        String subjectId = sc.next();
        System.out.print("점수를 입력하시오...");
        int score = sc.nextInt();

        Student student = findStudentById(studentId);
        Subject subject = findSubjectById(subjectId);

        if (student != null && subject != null) {
            Score scoreRecord = new Score(sequence(INDEX_TYPE_SCORE), studentId, subjectId, score);
            scoreStore.add(scoreRecord);
            System.out.println("점수가 등록되었습니다.");
        } else {
            System.out.println("학생 또는 과목을 찾을 수 없습니다.");
        }
    }

    // 점수 목록 조회 메서드
    private static void inquireScore() {
        System.out.println("\n점수 목록 조회");
        scoreStore.forEach(score -> System.out.printf("ID: %s, 학생 ID: %s, 과목 ID: %s, 점수: %d%n",
                score.getScoreId(), score.getStudentId(), score.getSubjectId(), score.getScore()));
    }

    // 점수 수정 메서드
    private static void updateScore() {
        System.out.print("\n수정할 점수 ID를 입력하시오...");
        String scoreId = sc.next();
        Score score = findScoreById(scoreId);

        if (score != null) {
            System.out.print("새 점수를 입력하시오...");
            int newScore = sc.nextInt();
            score.setScore(newScore);
            System.out.println("점수가 수정되었습니다.");
        } else {
            System.out.println("점수를 찾을 수 없습니다.");
        }
    }

    // 점수 삭제 메서드
    private static void deleteScore() {
        System.out.print("\n삭제할 점수 ID를 입력하시오...");
        String scoreId = sc.next();
        Score score = findScoreById(scoreId);

        if (score != null) {
            scoreStore.remove(score);
            System.out.println("점수가 삭제되었습니다.");
        } else {
            System.out.println("점수를 찾을 수 없습니다.");
        }
    }

    // 학생 찾기 메서드
    private static Student findStudentById(String studentId) {
        return studentStore.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElse(null);
    }

    // 과목 찾기 메서드
    private static Subject findSubjectById(String subjectId) {
        return subjectStore.stream()
                .filter(subject -> subjectId.equals(subject.getSubjectId()))
                .findFirst()
                .orElse(null);
    }

    // 점수 찾기 메서드
    private static Score findScoreById(String scoreId) {
        return scoreStore.stream()
                .filter(score -> scoreId.equals(score.getScoreId()))
                .findFirst()
                .orElse(null);
    }
}
