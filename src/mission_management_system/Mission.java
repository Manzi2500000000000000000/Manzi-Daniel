package mission_management_system;

import java.util.*;

public abstract class Mission {
      protected String missionId;
      protected String missionName;
      protected Date missionStartDate;
      protected Date missionEndDate;
      protected String status;
      protected List<Personnel> assignedPersonnel = new ArrayList<>();
      
      
	public Mission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		
		if(missionStartDate.after(missionEndDate)) {
			throw new IllegalArgumentException("Start Date must be before End Date.");
		}
		this.missionId = missionId;
		this.missionName = missionName;
		this.missionStartDate = missionStartDate;
		this.missionEndDate = missionEndDate;
		this.status = status;
	}
	
	
	public void addPersonnel(Personnel person) {
		if(!assignedPersonnel.contains(person)) {
			assignedPersonnel.add(person);
			person.setAssignedMission(this);
		}
	}
	
	public abstract void assignedTask();
	public abstract void allocatedResources(List<Resource> availableResources);
	public abstract void trackMissionProgress();
	public abstract void generateMissionReport();
	
      
      
}
