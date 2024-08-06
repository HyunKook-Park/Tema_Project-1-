package FirstTeamProject;

import java.util.*;

public class Student {
    private String studentName;
    private String studentid;
    private List<String> enrolledSubjectIds;
    private String status;


    public Student(String studentId, String studentName) {
        this.studentid = studentId;
        this.studentName = studentName;
        this.status = "Green";
    }

    public Student(String seq, String studentName, List<String> enrolledSubjectIds) {
        this.studentid = seq;
        this.studentName = studentName;
        this.enrolledSubjectIds = enrolledSubjectIds;
    }

    // Getter
    public String getStudentId() {
        return studentid;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
