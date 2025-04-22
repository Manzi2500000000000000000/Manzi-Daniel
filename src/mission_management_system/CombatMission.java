package mission_management_system;

import java.util.*;

public class CombatMission extends Mission {
	 private List<String> combatTasks = new ArrayList<>();
     private List<Resource> usedResources = new ArrayList<>();
     
	public CombatMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		super(missionId, missionName, missionStartDate, missionEndDate, status);
	}

	@Override
	public void assignedTask() {
		 if (assignedPersonnel.size() < 3) {
	            System.out.println("Error: At least three personnel are required for combat missions.");
	            return;
	        }

	        for (Personnel p : assignedPersonnel) {
	            combatTasks.add("Combat Assignment for " + p.getPersonnelName());
	        }
		
	}

	@Override
	public void allocatedResources(List<Resource> availableResources) {
		  for (Resource r : availableResources) {
	            if ((r.getResourceName().equalsIgnoreCase("Weapon") ||
	                 r.getResourceName().equalsIgnoreCase("Vehicle")) && r.getQuantity() > 0) {
	                usedResources.add(r);
	                r.setQuantity(r.getQuantity() - 1);
	            }
	        }

	        if (usedResources.isEmpty()) {
	            System.out.println("Error: No combat equipment available.");
	        }
		
	}

	@Override
	public void trackMissionProgress() {
		status = combatTasks.isEmpty() ? "PLANNED" : "IN_PROGRESS";
		
	}

	@Override
	public void generateMissionReport() {
		 System.out.println("=== Combat Mission Report ===");
	        printCommonReportDetails();
		
	}
	
	 private void printCommonReportDetails() {
	        System.out.println("Mission: " + missionName + " [" + status + "]");
	        System.out.println("Start-End: " + missionStartDate + " to " + missionEndDate);
	        System.out.println("Personnel:");
	        assignedPersonnel.forEach(p -> System.out.println("- " + p.getPersonnelName() + " (" + p.getPersonnelRole() + ")"));
	        System.out.println("Resources Used:");
	        usedResources.forEach(r -> System.out.println("- " + r.getResourceName()));
	    }   
     
}
