package FirstTeamProject;

import java.util.HashMap;
import java.util.Map;

public class Student{
    private Map<String, String> StudentInfoGroup = new HashMap<>();
    private String StudentName;
    private String UniqueId;
    private String Subject;



    public void infoSet(String StudentName, String UniqueId){
        this.StudentName = StudentName;
        this.UniqueId = UniqueId;
        StudentInfoGroup.put(this.UniqueId, this.StudentName);
        StudentInfoGroup.put(this.StudentName, this.UniqueId);

    }
    public String getStudentName(String UniqueId){
        return StudentInfoGroup.get(UniqueId);
    }

    public String getUniqueId(String StudentName){
        return StudentInfoGroup.get(StudentName);
    }




}
