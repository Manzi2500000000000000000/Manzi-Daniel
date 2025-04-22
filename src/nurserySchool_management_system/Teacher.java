package nurserySchool_management_system;

public class Teacher {
	private String teacherId;
	private String teacherName;
	private String teacherRole;
	private NurseryClass assignedClass;
	
	
	public Teacher(String teacherId, String teacherName, String teacherRole) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherRole = teacherRole;
	}
	
	public void setAssignedClass(NurseryClass assignedClass) {
		this.assignedClass = assignedClass;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getTeacherRole() {
		return teacherRole;
	}

	
	
	

}
