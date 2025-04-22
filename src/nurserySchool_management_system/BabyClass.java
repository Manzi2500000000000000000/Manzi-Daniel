package nurserySchool_management_system;

public class BabyClass extends NurseryClass {

	public BabyClass(String classId) {
		super(classId,"Baby Class", 15);
	}

	@Override
	public boolean enrollStudent(Student student) {
		if(student.getAge() < 2 || student.getAge() > 3 || students.size() >= maxCapacity) {
			return false;
		}
		students.add(student);
		student.setRegisteredClass(this);
		return true;
		
	}

	@Override
	public void trackProgress() {
		addProgress("Provided Skills monitored");
		
	}

	@Override
	public void conductActivity(String activityName) {
		activities.add(activityName);
		
	}

	@Override
	public void generateClassReport() {
		 System.out.println("\n--- Baby Class Report ---");
	        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "Unassigned"));
	        System.out.println("Number of students: " + students.size());
	        System.out.println("Activities: " + activities);
	        System.out.println("Progress: \n" + progressNotes);
		
	}
	
	
	
	

}
