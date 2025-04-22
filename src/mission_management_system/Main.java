package mission_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Resource> availableResources = new ArrayList<>();
	
	public static void main(String[] args) throws ParseException {
		System.out.println("=== Mission Management System ===");
		
		String type;
		while(true) {
			
			System.out.println("Enter mission type (Recon/Rescue/Combat/Humanitarian): ");
			type = scanner.nextLine().trim().toLowerCase();
			if(Arrays.asList("recon", "rescue", "combat", "humanitarian").contains(type)) break;
			System.out.println("Invalid type. Please choose a right type");
		}
		
		System.out.println("Enter Mission ID: ");
		String missionId = scanner.nextLine().trim();
		
		System.out.println("Enter Mission Name");
		String missionName = scanner.nextLine().trim();	
		
		Date missionStartDate, missionEndDate;
		while(true) {
			try {
			System.out.println("Enter Start Date (yyyy-MM-dd)");
			missionStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine().trim());
			
			System.out.println("Enter End Date (yyy-MM-dd): ");
			missionEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine().trim());
			
			if(missionStartDate.after(missionEndDate)) {
				System.out.println("Start Date must be before End Date. Try again.");
				continue;
			}
			break;
		} catch (ParseException e) {
			System.out.println("Invalid date format. Use yyy-MM-dd.");
		}
	}
		System.out.println("Enter status (PLANNED, IN_PROGRESS, COMPLETED): ");
		String status = scanner.nextLine().trim();
		
		Mission mission = createMission(type, missionId, missionName, missionStartDate, missionEndDate, status);
		if(mission == null) return;
		
		int personnelCount;
		while(true) {
			System.out.println("How many personnel to assign? ");
			try {
				personnelCount = Integer.parseInt(scanner.nextLine().trim());
				if(personnelCount <= 0) throw new NumberFormatException();
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid positive number.");
			}
		}
		
		Set<String> seenPersonnelIds = new HashSet<>();
		for(int i = 0; i < personnelCount; i++) {
			System.out.println("Enter details for personnel "+ (i+1));
			
			String pid;
			do {
				System.out.println("ID: ");
				pid = scanner.nextLine().trim();
				if(seenPersonnelIds.contains(pid)) {
					System.out.println("Duplicate ID detected. Enter a unique ID.");
				}
			} while(seenPersonnelIds.contains(pid));
			seenPersonnelIds.add(pid);
			
			String pname;
			while(true) {
				System.out.println("Name: ");
				pname = scanner.nextLine().trim();
				if(pname.matches("[a-zA-Z ]+")) break;
				System.out.println("Name must contain only letters.");
			}
			
			System.out.println("Role (Medic, Soldier, Logistics Officer, etc.);");
			String prole = scanner.nextLine().trim();
			
			Personnel person = new Personnel(pid, pname, prole);
			mission.addPersonnel(person);
			
			
			System.out.println("\nWould you like to enter available resources? (yes/no): ");
			String addResources = scanner.nextLine().trim().toLowerCase();
			if(addResources.equals("yes")) {
				while(true) {
					System.out.println("Enter resource ID");
					String resId = scanner.nextLine().trim();
					
					System.out.println("Enter resource name: ");
					String resName = scanner.nextLine().trim();
					
					int qty;
					while(true) {
						System.out.println("Enter quantity: ");
						try {
							qty = Integer.parseInt(scanner.nextLine().trim());
							if(qty <= 0) throw new NumberFormatException();
							break;
						} catch (NumberFormatException e) {
							System.out.println("Please Enter a valid positive number.");
						}
					}
					
					System.out.println("Enter resource type (e.g. Equipment, Medical Supplies): ");
					String typeRes = scanner.nextLine().trim();
					
					availableResources.add(new Resource(resId, resName, qty, typeRes));
					
					System.out.println("Add another resource: (yes/no)");
					if(!scanner.nextLine().trim().equalsIgnoreCase("yes")) break;
				}
			} else {
				// Use default if none entered
				//initializeDefaultResources();
			}
			
			// Mission Operation
			System.out.println("\nAssigning tasks...");
			mission.assignedTask();
			
			System.out.println("\nAllocating resources...");
			mission.allocatedResources(availableResources);
			
			System.out.println("\nTracking mission progress...");
			mission.trackMissionProgress();
			
			System.out.println("\nGenerating mission report...");
			mission.generateMissionReport();
			
			
		
	}


	}
	
	private static Mission createMission(String type, String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
		
		switch(type.toLowerCase()) {
		case "recon":
			  return new ReconMission(missionId, missionName, missionStartDate, missionEndDate, status);
        case "rescue":
            return new RescueMission(missionId, missionName, missionStartDate, missionEndDate, status);
        case "combat":
            return new CombatMission(missionId, missionName, missionStartDate, missionEndDate, status);
        case "humanitarian":
            return new HumanitarianMission(missionId, missionName, missionStartDate, missionEndDate, status);
        default:
        	return null;
		}
		
		
	}

}

