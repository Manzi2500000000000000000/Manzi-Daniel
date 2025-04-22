package Land_Management_System;

import java.util.Date;

public class IndustrialLand extends Land {
     private boolean environmentalClearance;

	public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean environmentalClearance) {
		super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
		this.environmentalClearance = environmentalClearance;
	}

	@Override
	public boolean validateOwnership() {
		return ownerName != null && !ownerName.trim().isEmpty();
	}

	@Override
	public boolean checkZoningCompliance() {
		return environmentalClearance;
	}

	@Override
	public double calculateTax() {
		return sizeInAcres * 12000 * 0.03;
	}

	@Override
	public void generateLandReport() {
		 printHeader("Industrial");
	        System.out.println("Land ID: " + landId);
	        System.out.println("Owner: " + ownerName);
	        System.out.println("Location: " + location);
	        System.out.println("Size (Acres): " + sizeInAcres);
	        System.out.println("Registration Date: " + registrationDate);
	        System.out.println("Land Use Status: " + landUseStatus);
	        System.out.println("Environmental Clearance: " + (environmentalClearance ? "Yes" : "No"));
	        System.out.println("Ownership Valid: " + (validateOwnership() ? "Yes" : "No"));
	        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Yes" : "No"));
	        System.out.printf("Calculated Tax: $%.2f\n", calculateTax());
	        System.out.println("=============================================================================\n");
		
	}

	
	
     
     
}
