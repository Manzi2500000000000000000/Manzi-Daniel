package nurserySchool_management_system;

import java.util.*;

public abstract class NurseryClass {
	protected String classId;
	protected String className;
	protected int maxCapacity;
	protected Teacher assignedTeacher;
	protected List<Student> students = new ArrayList<>();
	protected List<String> activities = new ArrayList<>();
	protected String progressNotes = "";
	
	public NurseryClass(String classId, String className, int maxCapacity) {
		this.classId = classId;
		this.className = className;
		this.maxCapacity = maxCapacity;
	}
	
	public abstract boolean enrollStudent(Student student);
	public abstract void trackProgress();
	public abstract void conductActivity(String activityName);
	public abstract void generateClassReport();

	
	public void assignTeacher(Teacher teacher) {
		this.assignedTeacher = teacher;
		teacher.setAssignedClass(this);
	}
	
	public String getClassName() {
		return className;
	}

	public Teacher getAssignedTeacher() {
		return assignedTeacher;
	}
	
	public int getStudentCount() {
		return students.size();
	}

	public List<String> getActivities() {
		return activities;
	}
	
	public void addProgress(String note) {
		this.progressNotes += note + "\n";
	}
	
	

}
