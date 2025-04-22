package nurserySchool_management_system;

public class MiddleClass extends NurseryClass {

	public MiddleClass(String classId) {
		super(classId, "Middle Class", 20);
		
	}

	@Override
	public boolean enrollStudent(Student student) {
		if (student.getAge() < 3 || student.getAge() > 4 || students.size() >= maxCapacity) {
            return false;
        }
        students.add(student);
        student.setRegisteredClass(this);
        return true;
	}

	@Override
	public void trackProgress() {
		 addProgress("Provided activities tracked.");
		
	}

	@Override
	public void conductActivity(String activityName) {
		activities.add(activityName);
		
	}

	@Override
	public void generateClassReport() {
		 System.out.println("\n--- Middle Class Report ---");
	        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "Unassigned"));
	        System.out.println("Number of students: " + students.size());
	        System.out.println("Activities: " + activities);
	        System.out.println("Progress: \n" + progressNotes);
		
	}
	
	
	
	

}
