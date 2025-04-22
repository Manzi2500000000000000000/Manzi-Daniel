package nurserySchool_management_system;

public class TopClass extends NurseryClass {
	 public TopClass(String classId) {
	        super(classId, "Top Class", 25);
	    }

	    @Override
	    public boolean enrollStudent(Student student) {
	        if (student.getAge() < 4 || student.getAge() > 5 || students.size() >= maxCapacity) {
	            return false;
	        }
	        students.add(student);
	        student.setRegisteredClass(this);
	        return true;
	    }

	    @Override
	    public void trackProgress() {
	        addProgress("Provided Activities tracked.");
	    }

	    @Override
	    public void conductActivity(String activityName) {
	        activities.add(activityName);
	    }

	    @Override
	    public void generateClassReport() {
	        System.out.println("\n--- Top Class Report ---");
	        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "Unassigned"));
	        System.out.println("Number of students: " + students.size());
	        System.out.println("Activities: " + activities);
	        System.out.println("Progress: \n" + progressNotes);
	    }

}
