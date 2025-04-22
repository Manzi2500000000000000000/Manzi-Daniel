package mission_management_system;

import java.util.*;

public class RescueMission extends Mission {
     private List<String> allocatedTasks = new ArrayList<>();
     private List<Resource> allocatedResources = new ArrayList<>();
     
	public RescueMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		super(missionId, missionName, missionStartDate, missionEndDate, status);
	}

	@Override
	public void assignedTask() {
		boolean hasMedic = assignedPersonnel.stream()
				.anyMatch(p -> p.getPersonnelRole().equalsIgnoreCase("Medic"));
		if(!hasMedic) {
			System.out.println("Error: At least one Medic is required for a rescue mission.");
			return;
		}
		
		for(Personnel person : assignedPersonnel) {
			allocatedTasks.add("Rescue Task for "+ person.getPersonnelName());
		}
		
	}

	@Override
	public void allocatedResources(List<Resource> availableResources) {
		boolean allocated = false;
		for (Resource res : availableResources) {
			if((res.getResourceName().equalsIgnoreCase("Medical Kit") || 
					res.getResourceName().equalsIgnoreCase("Ambulance")) && res.getQuantity() > 0) {
				allocatedResources.add(res);
				res.setQuantity(res.getQuantity() - 1);
				allocated = true;
			}
		}
		if(!allocated) {
			System.out.println("Error: No medical supplies or ambulance available.");
		}
		
	}

	@Override
	public void trackMissionProgress() {
		status = allocatedTasks.isEmpty() ? "PLANNED" : "IN_PROGRESS";
		
	}

	@Override
	public void generateMissionReport() {
		System.out.println("=== Rescue Mission Report ===");
		printCommonReportDetails();
		
	}
	
	private void printCommonReportDetails() {
		System.out.println("Mission: "+ missionName + " ["+ status + "]");
		System.out.println("Start-End: "+ missionStartDate+ " to "+ missionEndDate);
		System.out.println("Personnel: ");
		assignedPersonnel.forEach(p -> System.out.println("- "+p.getPersonnelName()+" ("+ p.getPersonnelRole()+") "));
		System.out.println("Resources Used: ");
		allocatedResources.forEach(r ->System.out.println("- "+ r.getResourceName()));
	}
	
	
     
     
}
