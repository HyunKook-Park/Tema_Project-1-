package FirstTeamProject;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";


    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다. " + e.getMessage());
        }
    }

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
        scoreStore = new ArrayList<>();
    }

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
        return type;
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


    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

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
                case 8 -> flag = false; // 메인 화면 이동 // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static List<String> selectSubjects(String subjectType, int requiredCount) {
        List<String> selectedSubjects = new ArrayList<>();
        List<Subject> availableSubjects = new ArrayList<>();

        // 선택할 과목 목록 필터링
        for (Subject subject : subjectStore) {
            if (subject.getSubjectType().equalsIgnoreCase(subjectType)) {
                availableSubjects.add(subject);
            }
        }

        System.out.println(subjectType.equalsIgnoreCase(SUBJECT_TYPE_MANDATORY) ? "\n필수 과목 선택:" : "\n선택 과목 선택");

        // 과목 목록을 보여줌
        System.out.println("선택 가능한 과목 목록:");
        for (int i = 0; i < availableSubjects.size(); i++) {
            System.out.println((i + 1) + ". " + availableSubjects.get(i).getSubjectName());
        }

        // 사용자가 원하는 과목을 선택하도록 유도
        while (selectedSubjects.size() < requiredCount) {
            System.out.print("선택할 과목명을 입력하세요 (남은 수: " + (requiredCount - selectedSubjects.size()) + "): ");
            String selectedSubjectName = sc.nextLine();

            boolean found = false;
            for (Subject subject : availableSubjects) {
                if (subject.getSubjectName().equalsIgnoreCase(selectedSubjectName)) {
                    if (!selectedSubjects.contains(selectedSubjectName)) {
                        selectedSubjects.add(selectedSubjectName);
                        found = true;
                        break;
                    } else {
                        System.out.println("이미 선택한 과목입니다.");
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("잘못된 과목명입니다. 다시 입력하세요.");
            }
        }

        return selectedSubjects;
    }

    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();

        List<String> mandatorySubjects = selectSubjects(SUBJECT_TYPE_MANDATORY, 3);
        List<String> choiceSubjects = selectSubjects(SUBJECT_TYPE_CHOICE, 2);

        List<String> enrolledSubjectIds = new ArrayList<>();
        // 과목 Name를 enrolledSubjectIds에 추가
        for (String subjectName : mandatorySubjects) {
            Optional<Subject> subjectOpt = subjectStore.stream()
                    .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectName))
                    .findFirst();
            if (subjectOpt.isPresent()) {
                enrolledSubjectIds.add(subjectOpt.get().getSubjectId());
            }
        }
        for (String subjectName : choiceSubjects) {
            Optional<Subject> subjectOpt = subjectStore.stream()
                    .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectName))
                    .findFirst();
            if (subjectOpt.isPresent()) {
                enrolledSubjectIds.add(subjectOpt.get().getSubjectId());
            }
        }

        // 새로운 학생 객체 생성 (새로운 생성자 또는 기존 생성자와 필드 설정 사용)
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);
        student.setEnrolledSubjectIds(enrolledSubjectIds);
        studentStore.add(student);

        System.out.println("수강생 등록 성공!\n");
        System.out.println("선택한 필수 과목: " + mandatorySubjects);
        System.out.println("선택한 선택 과목: " + choiceSubjects);
    }


    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        if (studentStore.isEmpty()) {
            System.out.println("등록된 수강생이 없습니다.");
        } else {
            for (Student student : studentStore) {
                System.out.println("ID: " + student.getStudentId() + ", 이름: " + student.getStudentName());
            }
        }
        System.out.println("\n수강생 목록 조회 성공!");
    }

    // 수강생 상태 관리
    private static void manageStudentStatus() {
        String studentId = getStudentId();
        Optional<Student> studentOpt = studentStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst();
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("현재 상태: " + student.getStatus());
            System.out.println("현재 상태를 선택하세요 (Green, Yellow, Red): ");
            String newStatus = sc.next().toLowerCase();

            if (newStatus.equalsIgnoreCase("green") || newStatus.equalsIgnoreCase("yellow") || newStatus.equalsIgnoreCase("red")) {
                student.setStatus(newStatus.substring(0, 1).toUpperCase() + newStatus.substring(1));
                System.out.println("상태 변경 완료");
            } else {
                System.out.println("잘못된 상태입니다.");
            }
        } else {
            System.out.println("존재하지 않는 수강생 입니다.");
        }
    }

    // 수강생의 상세 정보 조회
    private static void viewStudentInfo() {
        String studentId = getStudentId();
        Optional<Student> studentOpt = studentStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst();
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("ID: " + student.getStudentId());
            System.out.println("이름: " + student.getStudentName());
            System.out.println("상태: " + student.getStatus());

            List<String> subjects = getStudentSubjects(student.getEnrolledSubjectIds());
            System.out.println("선택한 과목명: " + subjects);
            if (subjects.isEmpty()) {
                System.out.println("등록된 과목이 없습니다.");
            } else {
                for (String subject : subjects) {
                    System.out.println("- " + subject);
                }
            }
        } else {
            System.out.println("존재하지 않는 수강생입니다.");
        }
    }

    // 수강생 상세 정보 조회 기능 안에서 수강생이 선택한 과목을 조회하는 기능
    private static List<String> getStudentSubjects(List<String> enrolledSubjectIds) {
        // 학생의 점수 기록에서 과목 ID를 찾아서 중복 없이 과목 이름 목록을 반환
                    // 과목 ID로 과목을 찾고, 해당 과목의 이름을 반환
        return subjectStore.stream()
                .filter(s->enrolledSubjectIds.contains(s.getSubjectId()))
                .map(Subject::getSubjectName)
                .toList();
    }

    // 수강생 정보 수정(이름, 상태)
    private static void updateStudentInfo() {
        String studentId = getStudentId();
        Optional<Student> studentOpt = studentStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst();

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("현재 이름: " + student.getStudentName());
            System.out.println("새 이름 입력: ");
            String newName = sc.next();

            System.out.println("현재 상태: " + student.getStatus());
            System.out.println("새 상태 입력 (Green, Yellow, Red): ");
            String newStatus = sc.next().toLowerCase();

            if (newStatus.equalsIgnoreCase("Green") || newStatus.equalsIgnoreCase("yellow") || newStatus.equalsIgnoreCase("red")) {
                student = new Student(studentId, newName, student.getEnrolledSubjectIds());
                student.setStatus(newStatus);
                studentStore.removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
                studentStore.add(student);

                System.out.println("정보 수정 완료!");
            } else {
                System.out.println("잘못된 상태입니다.");
            }
        } else {
            System.out.println("존재하지 않는 수강생입니다.");
        }
    }

    // 상태별 수강생 목록 조회
    private static void viewStudentsByStatus() {
        System.out.println("상태를 입력하세요 (Green, Yellow, Red): ");
        String status = sc.next().toLowerCase();

        if (status.equalsIgnoreCase("green") || status.equalsIgnoreCase("yellow") || status.equalsIgnoreCase("red")) {
            List<Student> filteredStudents = studentStore.stream()
                    .filter(s -> s.getStatus().equalsIgnoreCase(status))
                    .toList();

            if (filteredStudents.isEmpty()) {
                System.out.println("해당 상태의 수강생이 없습니다.");
            } else {
                for (Student student : filteredStudents) {
                    System.out.println("ID: " + student.getStudentId() + ", 이름" + student.getStudentName());
                }
            }
        } else {
            System.out.println("잘못된 상태입니다. ");
        }
    }

    // 수강생 삭제 및 점수 기록 삭제
    private static void deleteStudent() {
        String studentId = getStudentId();
        Optional<Student> studentOpt = studentStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst();

        if (studentOpt.isPresent()) {
            // 일방적으로 ID 와 같은 고유 식별자를 사용하여 리스트에서 객체를 제거할 때는 'removeIf' 더 간결하고 직접적인 방법.
            // Optional을 사용하여, studentOpt.ifPresent(studentStore::remove); 를 상횰 경우 객체를 찾는 작업을 추가로 해야함.
            studentStore.removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
            scoreStore.removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
            System.out.println("수강생과 관련된 기록이 모두 삭제되었습니다.");
        } else {
            System.out.println("존재하지 않는 수강생입니다.");
        }
    }

    // Score view
    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 수강생의 과목별 평균 등급 조회");
            System.out.println("5. 특정 상태 수강생들의 필수 과목 평균 등급 조회");
            System.out.println("6. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            switch (input) {
                case 1 -> createScore();
                case 2 -> updateRoundScoreBySubject();
                case 3 -> inquireRoundGradeBySubject();
                case 4 -> inquireAverageGradeBySubject();
                case 5 -> inquireAverageGradeByStatus();
                case 6 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        System.out.println("과목명을 입력하세요: ");
        String subjectName = sc.next();
        System.out.println("회차를 입력하세요: ");
        int round = sc.nextInt();
        System.out.println("시험 점수를 입력해주세요");
        int score = sc.nextInt();

        if (round < 1 || round > 10) {
            System.out.println("회차는 1에서 10사이여야 합니다.");
            return;
        }
        if (score < 0 || score > 100) {
            System.out.println("점수는 0에서 100사이여야 합니다.");
            return;
        }
        Optional<Subject> subject = subjectStore.stream()
                .filter(s -> s.getSubjectName().equalsIgnoreCase(subjectName))
                .findFirst();
        //  Optional 객체의 'get()' 메서드는 내부에 값이 존재할 때만 호출 가능 -> 값이 없을 경우 'NosuchElementExceotion' 발생
        //  따라서 'get()' 메서드를 호출하기 전에 값이 존재하는지 확인하는 것이 좋다(아래 처럼) -> 예외 방지
        if (subject.isPresent()) {
            scoreStore.add(new Score(sequence(INDEX_TYPE_SCORE), studentId, subject.get().getSubjectName(), round, score));
            System.out.println("\n 점수 등록 성공!");
        } else {
            System.out.println("존재하지 않는 과목입니다.");
        }

        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        System.out.println("과목명을 입력하세요ㅕ");
        String subjectName = sc.next();
        System.out.println("회차를 입력하세요: ");
        int round = sc.nextInt();
        System.out.println("시험 점수를 입력해주세요");
        int newScore = sc.nextInt();

        if (round < 1 || round > 10) {
            System.out.println("회차는 1에서 10사이여야 합니다.");
            return;
        }
        if (newScore < 0 || newScore > 100) {
            System.out.println("점수는 0에서 100사이여야 합니다.");
            return;
        }
        Optional<Score> score = scoreStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId) && s.getSubjectName().equalsIgnoreCase(subjectName) && s.getRound() == round)
                .findFirst();
        //  Optional 객체의 'get()' 메서드는 내부에 값이 존재할 때만 호출 가능 -> 값이 없을 경우 'NosuchElementExceotion' 발생
        //  따라서 'get()' 메서드를 호출하기 전에 값이 존재하는지 확인하는 것이 좋다(아래 처럼) -> 예외 방지
        if (score.isPresent()) {
            score.get().setScore(newScore);
            System.out.println("\n 점수 수정 성공!");
        } else {
            System.out.println("존재하지 않는 점수입니다.");
        }
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
// 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        System.out.println("과목명을 입력하세요: ");
        String subjectName = sc.next();
        System.out.println("회차를 입력하세요: ");
        int round = sc.nextInt();
// 기능 구현
        Score score = scoreStore.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId) && s.getSubjectName().equalsIgnoreCase(subjectName) && s.getRound() == round)
                .findFirst()
                .orElseThrow( () -> new NoSuchElementException("해당 스코어가 존재하지 않습니다." ));


        int scoreValue = score.getScore();
        String grade = calculateGrade(subjectName, scoreValue);
        System.out.println("점수: " + scoreValue + ", 등급: " + grade);
    }

    // 수강생의 특정 과목 회차별 등급 조회에서 점수별 등급 산정
    private static String calculateGrade(String subjectName, int score) {
        Subject subject = subjectStore.stream()
                .filter(s -> subjectName.equalsIgnoreCase(s.getSubjectName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("과목이 존재하지 않습니다."));


        if (subject.getSubjectType().equalsIgnoreCase(SUBJECT_TYPE_MANDATORY)) {
            if (score >= 95) return "A";
            else if (score >= 90) return "B";
            else if (score >= 80) return "C";
            else if (score >= 70) return "D";
            else if (score >= 60) return "F";
            else return "N";
        } else {
            if (score >= 90) return "A";
            else if (score >= 80) return "B";
            else if (score >= 70) return "C";
            else if (score >= 60) return "D";
            else if (score >= 50) return "F";
            else return "N";
        }
    }

    // 수강생의 과목별 평균 등급 조회
    private static void inquireAverageGradeBySubject() {
        String studentId = getStudentId();
        // 수강생의 점수 기록 필터링 하여 과목별 점수 목록 가져오기
        Map<String, List<Integer>> subjectScores = new HashMap<>();
        for (Score score : scoreStore) {
            if (score.getStudentId().equalsIgnoreCase(studentId)) {
                // key가 존재하지 않으면 새로운 리스트를 생성하고, 점수 추가
                subjectScores.computeIfAbsent(score.getSubjectName(), k -> new ArrayList<>()).add(score.getScore());
            }
        }
        if (subjectScores.isEmpty()) {
            System.out.println("해당 수강생의 점수가 없습니다.");
            return;
        }
        // 과목별 평균 점수 계산 및 등급 출력
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            String subjectId = entry.getKey();
            List<Integer> score = entry.getValue();
            double averageScore = score.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            // 과목 이름을 가져옵니다.
            Optional<Subject> subjectOpt = subjectStore.stream()
                    .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectId))
                    .findFirst();

            if (subjectOpt.isPresent()) {
                String subjectName = subjectOpt.get().getSubjectName();
                String grade = calculateGrade(subjectName, (int) (averageScore));
                System.out.println("과목명: " + subjectName + ", 평균 등급: " + grade);
            } else {
                System.out.println("존재하지 않는 과목입니다.");
            }
        }
    }

    // 특정 상태 수강생들의 필수 과목 평균 조회
    private static void inquireAverageGradeByStatus(){
        System.out.println("상태를 입력하세요 (Green, Yellow, Red): ");
        String status = sc.next();

        if (status.equalsIgnoreCase("green") || status.equalsIgnoreCase("yellow") || status.equalsIgnoreCase("red")) {
            List<Student> studentsList = studentStore.stream()
                    .filter(s->s.getStatus().equalsIgnoreCase(status))
                    .toList();

            if (studentsList.isEmpty()) {
                System.out.println("해당 상태의 수강생이 존재하지 않습니다.");
                return;
            }
            // 필수 과목에 대한 평균 등급 조회
            for(Student student : studentsList) {
                List<String> mandatorySubjectList = subjectStore.stream()
                        .filter(subject -> SUBJECT_TYPE_MANDATORY.equalsIgnoreCase(subject.getSubjectType()))
                        .map(Subject::getSubjectName)
                        .toList();
                List<Integer> mandatorySubjectScoreList = new ArrayList<>();  // 필수과목에 대한 점수 담는 리스트 생성
                for (Score score : scoreStore) {
                    if (score.getStudentId().equalsIgnoreCase(student.getStudentId()) && mandatorySubjectList.contains(score.getSubjectName())) {
                        mandatorySubjectScoreList.add(score.getScore());
                    }
                }
                if (mandatorySubjectScoreList.isEmpty()) {
                    System.out.println("수강생 " + student.getStudentName() + "의 필수 과목 점수가 없습니다.");
                    continue;
                }
                double averageScore = mandatorySubjectScoreList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                String grade = calculateMandatoryGrade((int) averageScore);
                System.out.println("수강생 이름 : " + student.getStudentName() + ", 필수 과목 평균 등급: " + grade);
            }
        }else{
            System.out.println("잘못된 상태입니다.");
        }
    }

    private static String calculateMandatoryGrade(int score) {
            if (score >= 95) return "A";
            else if (score >= 90) return "B";
            else if (score >= 80) return "C";
            else if (score >= 70) return "D";
            else if (score >= 60) return "F";
            else return "N";
    }
}