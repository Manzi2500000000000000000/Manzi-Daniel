package nurserySchool_management_system;

public class Student {
	private String studentId;
	private String studentName;
	private int age;
	private String guardianName;
	private NurseryClass registeredClass;
	
	
	public Student(String studentId, String studentName, int age, String guardianName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.guardianName = guardianName;
	}
	
	
    public void setRegisteredClass(NurseryClass registeredClass) {
    	this.registeredClass = registeredClass;
    }

	public String getStudentId() {
		return studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public int getAge() {
		return age;
	}

}
