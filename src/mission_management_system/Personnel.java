package mission_management_system;

public class Personnel {
      private String personnelId;
      private String personnelName;
      private String personnelRole;
      private Mission assignedMission;
      
	public Personnel(String personnelId, String personnelName, String personnelRole) {
		this.personnelId = personnelId;
		this.personnelName = personnelName;
		this.personnelRole = personnelRole;
	}

	public String getPersonnelId() {
		return personnelId;
	}

	public String getPersonnelName() {
		return personnelName;
	}

	public String getPersonnelRole() {
		return personnelRole;
	}

	public Mission getAssignedMission() {
		return assignedMission;
	}

	public void setAssignedMission(Mission assignedMission) {
		this.assignedMission = assignedMission;
	}

	
	
	
	
      
      
}
