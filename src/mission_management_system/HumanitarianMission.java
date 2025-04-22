package mission_management_system;

import java.util.*;

public class HumanitarianMission extends Mission {
	 private List<String> aidTasks = new ArrayList<>();
     private List<Resource> aidResources = new ArrayList<>();
     
	public HumanitarianMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		super(missionId, missionName, missionStartDate, missionEndDate, status);
		
	}

	@Override
	public void assignedTask() {
		for (Personnel p : assignedPersonnel) {
            if (p.getPersonnelRole().equalsIgnoreCase("Logistics Officer") ||
                p.getPersonnelRole().equalsIgnoreCase("Medic")) {
                aidTasks.add("Humanitarian task for " + p.getPersonnelName());
            }
        }

        if (aidTasks.isEmpty()) {
            System.out.println("Error: No qualified personnel (Logistics or Medic) assigned.");
        }
		
	}

	@Override
	public void allocatedResources(List<Resource> availableResources) {
		 boolean hasEssentialResources = false;
	        for (Resource r : availableResources) {
	            if ((r.getResourceName().equalsIgnoreCase("Food Supply") ||
	                 r.getResourceName().equalsIgnoreCase("Medical Kit")) && r.getQuantity() > 0) {
	                aidResources.add(r);
	                r.setQuantity(r.getQuantity() - 1);
	                hasEssentialResources = true;
	            }
	        }

	        if (!hasEssentialResources) {
	            System.out.println("Error: No food or medical supplies available for humanitarian mission.");
	        }
		
	}

	@Override
	public void trackMissionProgress() {
		status = aidTasks.isEmpty() ? "PLANNED" : "IN_PROGRESS";
		
	}

	@Override
	public void generateMissionReport() {
		  System.out.println("=== Humanitarian Mission Report ===");
	      printCommonReportDetails();
		
	}
	
	private void printCommonReportDetails() {
	        System.out.println("Mission: " + missionName + " [" + status + "]");
	        System.out.println("Start-End: " + missionStartDate + " to " + missionEndDate);
	        System.out.println("Personnel:");
	        assignedPersonnel.forEach(p -> System.out.println("- " + p.getPersonnelName() + " (" + p.getPersonnelRole() + ")"));
	        System.out.println("Resources Used:");
	        aidResources.forEach(r -> System.out.println("- " + r.getResourceName()));
	    }
     
     
}
