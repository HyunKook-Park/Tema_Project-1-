package FirstTeamProject;

import java.util.*;

public class Student {
    private String studentName;
    private String studentID;
    private String status;
    private List<String> enrolledSubjectIds;


    public Student(String studentId, String studentName) {
        this.studentID = studentId;
        this.studentName = studentName;
        this.status = "Green";
    }

    public Student(String seq, String studentName, List<String> enrolledSubjectIds) {
        this.studentID = seq;
        this.studentName = studentName;
        this.enrolledSubjectIds = enrolledSubjectIds;
    }

    // Getter
    public String getStudentId() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getEnrolledSubjectIds() {
        return enrolledSubjectIds;
    }

    public void setEnrolledSubjectIds(List<String> enrolledSubjectIds) {
        this.enrolledSubjectIds = enrolledSubjectIds;
    }

}
