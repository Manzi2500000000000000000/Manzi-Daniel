package mission_management_system;

import java.util.*;

public class ReconMission extends Mission {
     private List<String> allocatedTasks = new ArrayList<>();
     private List<Resource> allocatedResources = new ArrayList<>();
     
	public ReconMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		super(missionId, missionName, missionStartDate, missionEndDate, status);
		
	}

	
	@Override
	public void assignedTask() {
		if(assignedPersonnel.size() < 2) {
			System.out.println("Error: Atleast two personnel are required");
			return;
		}
		
		for(Personnel person : assignedPersonnel) {
			allocatedTasks.add("Recon Task for "+ person.getPersonnelName());
		}
		
	}

	@Override
	public void allocatedResources(List<Resource> availableResources) {
		boolean droneAvailable = false;
		
		for(Resource res : availableResources) {
			if(res.getResourceName().equalsIgnoreCase("Drone") && res.getQuantity() > 0) {
				droneAvailable = true;
				allocatedResources.add(res);
				res.setQuantity(res.getQuantity() - 1);
				break;
			}
		}
		if(!droneAvailable) {
			System.out.println("Error: Drones are not available for allocation.");
		}
	}

	@Override
	public void trackMissionProgress() {
		if(!allocatedTasks.isEmpty()) {
			status = "IN_PROGRESS";
		} else {
			status = "PLANNED";
		}
		
	}

	@Override
	public void generateMissionReport() {
		System.out.println("=== Recon Mission Report ===");
		System.out.println("Mission Name: "+missionName);
		System.out.println("status: "+status);
		System.out.println("Start Date: "+missionStartDate);
		System.out.println("End Date: "+missionEndDate);
		System.out.println("Tasks Assigned: "+allocatedTasks.size());
		System.out.println("Resources Used: ");
		
		for(Resource r : allocatedResources) {
			System.out.println("- "+r.getResourceName());
		}
		
		System.out.println("Personnel Assigned: ");
		for(Personnel p : assignedPersonnel) {
			System.out.println("- "+p.getPersonnelName()+ " ("+ p.getPersonnelRole()+" )");
		}
		
	}    
     
}
