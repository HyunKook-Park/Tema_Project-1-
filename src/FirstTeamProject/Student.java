package FirstTeamProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student {
    private String studentId;
    private String studentName;
    private String status;
    private List<String> enrolledSubjectIds;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledSubjectIds = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
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

    // Methods for student operations would go here
}
