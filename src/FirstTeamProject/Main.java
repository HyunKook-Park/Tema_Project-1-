package FirstTeamProject;

import java.util.*;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class Main {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static Map<List<Student>, List<Subject>> subjectByStudent;
    private static Map<Integer, Integer> roundByStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        subjectByStudent = new HashMap<>();
        roundByStore = new HashMap<>();
    }

    // index 자동 증가
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
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);
        studentStore.add(student);

        // 기능 구현 (필수 과목, 선택 과목)
        System.out.println("과목을 입력하시오...");
        String subjectType = sc.nextLine();
        Subject subject = new Subject(sequence(INDEX_TYPE_SUBJECT), subjectType, SUBJECT_TYPE_MANDATORY);
        subjectStore.add(subject);

        // 기능 구현
        System.out.println("수강생 등록 성공!\n");
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        studentStore.get(studentIndex);

        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId();              //중복x

        System.out.println("과목을 입력하세요...");
        String selectSubject = sc.nextLine();

        if(selectSubject.equals(INDEX_TYPE_SUBJECT)) {
//            subjectByStudent.put(studentId, selectSubject);
        }

        System.out.println("시험 점수를 등록합니다...");      //중복x
        System.out.print("회차를 입력하시오...(1~10)");
        int round = sc.nextInt();

        System.out.print("점수를 입력하시오...(0~100)");
        int score = sc.nextInt();

        try {
            if (round < 1 || round > 10) {
            }
        } catch (Exception e) {
            System.out.println("회차범위 1~10");
        }

        try {
            if (score < 0 || score > 100) {
            }
        } catch (Exception e) {
            System.out.println("점수 범위 0~100");
        }
//        roundByStore.put(round, List<String> subjectByStudent);
//        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("수정할 과목을 입력하시오...");
        String updateSubject = sc.nextLine();

        if(updateSubject.equals(INDEX_TYPE_SUBJECT)) {
//            subjectByStudent.put(studentId, updateSubject);


            System.out.println("시험 점수를 수정합니다...");
            System.out.println("수정할 회차를 입력하시오...");
            int updateRound = sc.nextInt();
            System.out.println("수정할 점수를 입력하시오...");
            int updateScore = sc.nextInt();

            try {
                if (updateRound < 1 || updateRound > 10) {
                }
            } catch (Exception e) {
                System.out.println("회차범위 1~10");
            }

            try {
                if (updateScore < 0 || updateScore > 100) {
                }
            } catch (Exception e) {
                System.out.println("점수 범위 0~100");
            }
            roundByStore.put(updateRound, updateScore);
            System.out.println("\n점수 수정 성공!");
        }
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        System.out.println("회차별 등급을 조회합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("조회할 과목을 입력하시오...");
        String viewSubject = sc.nextLine();


        System.out.println("조회할 회차를 선택하시오...");
        int viewRound = sc.nextInt();
        if (roundByStore.containsKey(viewRound)) {


            int score = roundByStore.get(viewRound);

            if (viewSubject.equals(SUBJECT_TYPE_MANDATORY)) {
                if (score >= 95) System.out.println("A");
                if (score >= 90) System.out.println("B");
                if (score >= 80) System.out.println("C");
                if (score >= 70) System.out.println("D");
                if (score >= 60) System.out.println("E");
                System.out.println("N");
            } else {
                if (score >= 90) System.out.println("A");
                if (score >= 80) System.out.println("B");
                if (score >= 70) System.out.println("C");
                if (score >= 60) System.out.println("D");
                if (score >= 50) System.out.println("E");
                System.out.println("N");
            }

            System.out.println(subjectByStudent.get(studentId) + "번 수강생 " + viewSubject + "과목");
            System.out.println(viewRound + "회차 등급:" + score);


            // 기능 구현
            System.out.println("\n등급 조회 성공!");
        }

    }
}
